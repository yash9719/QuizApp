package com.codewithyash.myquizapp

object Constants {

    var USER_NAME:String="user_name"
    var CORRECT_ANSWERS:String="total_questions"
    var TOTAL_QUESTIONS:String?="correct_answers"


    fun getQuestions():ArrayList<Question>{

        val questionList= ArrayList<Question>()

        val que1=Question(

            1,"The universal front end to database applications that connects to the backend through the internet,are the",
        R.drawable.img16,
            "Web browsers","Applications","Tools","Software programs",
            1
        )
        questionList.add(que1)


        val que2=Question(

            2,"The layer in the application's architecture which is conceptually broken up into furthers layers,is said to be",
            R.drawable.img,
            "Model layer","Data-access layer","View layer","Presentation layer",
            4
        )
        questionList.add(que2)

        val que3=Question(

            3,"A program that accepts requests from a Web browser and sends back results in the form of HTML documents,is known as",
            R.drawable.img_10,
            "Web host","Web server","Web interface","Web applications",
            2
        )
        questionList.add(que3)

        val que4=Question(

            4,"A program running on the server machine,is called",
            R.drawable.img_16,
            "Web server","Web applications","Web process","Web program",
            1
        )
        questionList.add(que4)

        val que5=Question(

            5,"The communication between application program and a database server,takes place through",
            R.drawable.img_8,
            "ODBC","JDBC","HTTP","ODBC OR JDBC",
            4
        )
        questionList.add(que5)

        val que6=Question(

            6,"The standard that defines the communication manner between Web server and application programs,is known to be",
            R.drawable.img_7,
            "HTTP","CGI","TTP","ATP",
            4
        )
        questionList.add(que6)

        val que7=Question(

            7,"The several technologies that are used by JavaScript to create dynamic web pages,are known as",
            R.drawable.img_6,
            "DOM","Ajax","MVC","MAVC",
            2
        )
        questionList.add(que7)

        val que8=Question(

            8,"The term in the MVC architecture that receives events is called",
            R.drawable.img_5,
            "Receiver","Controller","Transmitter","Modulator",
            2
        )
        questionList.add(que8)


        val que9=Question(

            9,"The standard that supports formatted display of information,and creation of forms based interfaces,is known to be",
            R.drawable.img_2,
            "Java","XML","Oracle","HTML",
            4
        )
        questionList.add(que9)



        return questionList

    }
}