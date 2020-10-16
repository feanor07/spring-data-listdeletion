# spring-data-listdeletion
Demo project to test whether there is any difference in deleting entities as a list together vs. iterating and deleting one by one.

## Enpoints
### Populate Books
Populates book table with a predefined list of books.
call: `curl -X POST http://localhost:8080/books/populate`

### Get all books
Fetch all books available in table.
call : `curl -X GET http://localhost:8080/books`

### Delete all books via repository.deleteAll
Delets the books in table all together via repository method.
call: `curl -X DELETE http://localhost:8080/books/aslist`

### Delete all books via iteration
Delets the books in table via for loop and calling repository `delete` one by one
call: `curl -X DELETE http://localhost:8080/books/iteration`

## Testing

### Deletion as list all together:
1. `curl -X POST http://localhost:8080/books/populate`
2. `curl -X GET http://localhost:8080/books` : Returns all books
3. `curl -X DELETE http://localhost:8080/books/aslist`
4. `curl -X GET http://localhost:8080/books` : Returns no books

### Deletion one by one:
1. `curl -X POST http://localhost:8080/books/populate`
2. `curl -X GET http://localhost:8080/books` : Returns all books
3. `curl -X DELETE http://localhost:8080/books/iteration`
4. `curl -X GET http://localhost:8080/books` : Returns no books

As a result; both ways seem to provide the same result and there seems to be no difference between two.
