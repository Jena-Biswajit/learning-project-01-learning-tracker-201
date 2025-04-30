package com.example.finalkeyword;

// if i declared this class as final then it will show
// now it will show error : Cannot inherit from final
// 'com.example.finalkeyword.FinalKeywordExample'

  class FinalKeywordExample {

    // final keyword in java is used as non-access modifier applicable to
    // a variable , method and class

    //  In java it is not mandatory to assign the
    //  value during final keyword value declaration

    final static int value = 10 ;

//      {
//          System.out.println("nonstatic block");
//      }
//     final static{
//          System.out.println("nonstatic block");
//      }

    public static void main(String[] args) {

       //now it will show error : Cannot assign a value to final variable 'value'
//      value = 20;

        System.out.println(value);
        FinalKeywordExample ob1 = new FinalKeywordExample();
        ob1.methodOverload();

    }

    // if i make this method declare as final then error :
    //methodOverload()' cannot override 'methodOverload()' in
    // 'com.example.finalkeyword.FinalKeywordExample'; overridden method is final
     void methodOverload(){
        System.out.println(" parent class");

    }
}


class FinalKeyWordInherit extends FinalKeywordExample{
//    public static void main(String[] args) {
//        System.out.println("inherited class");
//        FinalKeyWordInherit ob2 = new FinalKeyWordInherit();
//        ob2.methodOverload();
//    }

    void methodOverload(){
        System.out.println(" child method ");
    }
}
