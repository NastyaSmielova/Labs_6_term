
        var idDrinks = [];
        var idIngridients = [];
       document.getElementById("price").value = 0;
       
    function OnClick(type,id, name,price) {
        var ul = document.getElementById("list");
      //  alert(price);
      var curPrice  = 0;
      if (document.getElementById("price").value != "") 
          curPrice =  parseInt(document.getElementById("price").value);
        document.getElementById("price").value = curPrice + price;
        var li = document.createElement("li");
        li.appendChild(document.createTextNode(" " +name + " "+ price));
        if (type == "ingridient")  { 
           idIngridients.push(id);
            document.getElementById("textToSendIngridients").value = idIngridients;
      }
      else{ 
            idDrinks.push(id);
            document.getElementById("textToSendDrinks").value = idDrinks;
        }
        ul.appendChild(li);
    }
    