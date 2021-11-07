package android.newapi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.newapi.Implementation.Articles;
import android.newapi.Utils.utlis;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;


public class AdapterHome extends RecyclerView.Adapter<AdapterHome.NewsViewHolder> {
    private List<Articles> articles;
    private Context context;
    private OnItemClickListener onItem;
    public AdapterHome(List<Articles> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        return new NewsViewHolder(view, onItem);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
       final NewsViewHolder holder1=holder;
       Articles Implementation=articles.get(position);
       RequestOptions rq=new RequestOptions();
       rq.placeholder(utlis.getRandomdrawbleColor());
       rq.error(utlis.getRandomdrawbleColor());
       rq.diskCacheStrategy(DiskCacheStrategy.ALL);
       rq.centerCrop();
       Glide.with(context)
                .load(Implementation.getUrlToImage())
                .apply(rq).listener(new RequestListener<Drawable>() {
           @Override
           public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
               holder1.pb.setVisibility(View.GONE);
               return false;
           }

           @Override
           public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
               holder1.pb.setVisibility(View.GONE);
               return false;
           }
       }).transition(DrawableTransitionOptions.withCrossFade()).into(holder1.imageView);
       holder1.title.setText(Implementation.getTitle());
       holder1.descriptions.setText(Implementation.getDescription());
       holder1.source.setText(Implementation.getSource().getName());
       holder1.author.setText(Implementation.getAuthor());
       holder1.time.setText("\u2022"+utlis.DateToTimeFormats(Implementation.getPublishedAt()));
       holder1.published.setText(utlis.DateFormat(Implementation.getPublishedAt()));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public interface OnItemClickListener{
        void onItemClickPoint(View view ,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItem =  onItemClickListener;
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView title,descriptions,author,published,source,time;
        ProgressBar pb;
        OnItemClickListener onItemClickListener;
        ImageView imageView;

        public NewsViewHolder( View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            title=itemView.findViewById(R.id.title);
            descriptions=itemView.findViewById(R.id.descriptions);
            author=itemView.findViewById(R.id.author);
            published=itemView.findViewById(R.id.publishedAt);
            source=itemView.findViewById(R.id.source);
            time=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageView);
            pb=itemView.findViewById(R.id.Progressbar);
            this.onItemClickListener= onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClickPoint(v,getAdapterPosition());
        }
    }
}
