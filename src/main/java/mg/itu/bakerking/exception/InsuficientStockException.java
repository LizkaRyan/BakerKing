package mg.itu.bakerking.exception;

public class InsuficientStockException extends RuntimeException{
    public InsuficientStockException(double quantityStock,double quantityRequested,String product){
        super("Stock insuffisante pour "+product+". Il ne reste que "+quantityStock+" alors que vous demandez "+quantityRequested);
    }
}
