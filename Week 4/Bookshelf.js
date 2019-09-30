
class book {
   constructor(title, author, genre, coverImage) {
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.coverImage = coverImage;
   }
}
document.getElementById("NewBookButton").addEventListener("click",function(){
   let Title = document.getElementById("Title").value;
   let Author = document.getElementById("Author").value;
   let Genre = document.getElementById("Genre").value;
   let coverImage = document.getElementById("coverImage").value;
   let newBook = book(Title,Author,Genre,coverImage);
   addBookToShelf(newBook);
});

document.getElementById("ViewCollection").addEventListener("click",viewAllBooks);
bookshelf = [];
function addBookToShelf(book){
   bookshelf.push(book);
}
function viewAllBooks(){
   for(let key in bookshelf){
      console.print(bookshelf[key]);
   }
}

