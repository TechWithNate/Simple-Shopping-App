package comnate.shopapp.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import comnate.shopapp.R;
import comnate.shopapp.models.ProductModel;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<ProductModel> productModels;
    private Context context;
    private ProductItemClicked productItemClicked;

    public ProductAdapter(ArrayList<ProductModel> productModels, Context context, ProductItemClicked productItemClicked) {
        this.productModels = productModels;
        this.context = context;
        this.productItemClicked = productItemClicked;
    }

    public interface ProductItemClicked{
        void productClicked(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModel product = productModels.get(position);
        holder.productPrice.setText(product.getProductPrice());
        holder.productName.setText(product.getProductName());

        holder.itemView.setOnClickListener(v -> {
            productItemClicked.productClicked(position);
        });
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productName;
        private TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_img);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
