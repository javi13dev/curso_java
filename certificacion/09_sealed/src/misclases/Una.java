package misclases;

public sealed class Una permits Dos,Otra,Nueva{

}
sealed class Otra extends Una{
	
}
non-sealed class Nueva extends Una{
	
}

final class N extends Otra{
	
}