package Lesson3.stack

//обратить внимание, как используется  StackBracket для нужд класса
//при поступлении строки проходят по её элементам и пихают в стэк то, что нужно, а потом смотрят
//есть ли пара

class Bracket(val input:String){

    val size = input.length
    val st = StackBracket(size)

   fun  check(){
       for(i in input.indices){
           val ch = input[i]
          when (ch){
              '[','{','(' -> st.push(ch)
              ']', '}', ')' -> if (!st.isEmpty()){
                      val chr:Char = st.pop()
                      if ((ch == '}' && chr != '{')
                              || (ch == ']' && chr != '[')
                              || (ch == ')' && chr != '(')){

                          println("Error: $ch at $i")
                    }
                  }else{
                      println("Error: $ch at $i")
                  }
          }
       }
       if (!st.isEmpty()){
           println("Error: missing right delimiter")
       }
   }

}


