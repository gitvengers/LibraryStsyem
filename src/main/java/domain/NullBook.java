package domain;

public class NullBook extends Book{
    @Override
    public boolean isNull(){
        return true;
    }
}
