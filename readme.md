#TP CAR WEBAPP/JAVA EE

Johan Dufaux  
Allan Rakotoarivony  

Date : 23 April 2015
Version : 1.0


# Introduction

This program is a Java EE webserver. It provide a web store where people can register, connect and command books. There is a administrator page allowing to add news books.

### launch the program

In netbeans:
```
Start the glassfish server
Run the project
The main site is accessible to : http://localhost:8080/test1/accueil
```


# Design
The main application uses the MVC design pattern. JSP files are used as views, Servlets and session beans are used as controllers and entity beans with the database are used as models. 
Each entity beans like book or user represents a table in the database. To simplify access to database , a facade design pattern is used. Each entity has its own facade to easily access to the database CRUD operations.  
As it is a Java EE application, the program use library that is included in Java EE like servlets, EJB.
To simplify and not use java code in the JSP files, the JSTL library is used.

## Packages
| Nom | Description |
|-----|-------------|
| bean | contains file used as bean for session (actually the cart)|
| facade   | contains facade connecting application with database |
| model   | contains main class of the application |
| servlet  | contains servlet used to make link beetween url and jsp page (as controller) |


# Exceptions

There is no real exception handling..
```
```



# Code Samples

To display list of books, the program execute a loop on book. 
It doesn't use java code but EL and JSTL syntax.
```
<c:forEach items="${bookslist}" var="b">
    <div class="div_book">
        <span class="span_book_title">${b.title}</span>
        <div class="div_book_infos">
            <span class="span_book_year">${b.parutionYear} -</span>
            <span class="span_book_author">
                ${b.author.name}
                ${b.author.firstname}
            </span>
        </div>
        <button class="addbutton" value="${b.title}">Ajout au panier</button>
    </div>
</c:forEach>
```

To add a book on the cart, the program get the car on session, retreive the book from its name and add it to the cart.
```
CartBeanLocal cart = (CartBeanLocal) request.getSession().getAttribut(SHOPPING_CART_BEAN_SESION_KEY);
    
if(cart == null){
    cart = cartejb;  
    // put EJB in HTTP session for future servlet calls
    request.getSession().setAttribute(
      SHOPPING_CART_BEAN_SESION_KEY, 
      cart);
}

String bookname = request.getParameter("book");
Book thebook = bookfacade.find(bookname);
cart.addBook(thebook);
```



When administrator add a new book in database, the program receive the data with a post method and create new book in database. the page is returned with parameter to display informations.
```
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String title = request.getParameter("title");
	int year = Integer.parseInt(request.getParameter("year"));
	Author author = authorFacade.find(Integer.parseInt(request.getParameter("author")));
	Book newBook = new Book(title, year);
	newBook.setAuthor(author);

	bookFacade.create(newBook);

	request.setAttribute("chosen_author",author);
	request.setAttribute("book_added", true);

	processRequest(request, response);
}

```

An example of our cart session bean.
```
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class CartBean implements CartBeanLocal {

    private List<Book> books;
    
    @PostConstruct
    public void initCartBean(){
        books = new ArrayList<Book>();
    }
    
    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(Book b) {
        books.remove(b);
    }

    [...]
```



An example of entity in the application.
```
@Entity
@Table(name = "AUTHOR")
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = :id"),
    @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = :name"),
    @NamedQuery(name = "Author.findByFirstname", query = "SELECT a FROM Author a WHERE a.firstname = :firstname")})
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Collection<Book> bookCollection;

    public Author() {
    }

    public Author(Integer id) {
        this.id = id;
    }
```


