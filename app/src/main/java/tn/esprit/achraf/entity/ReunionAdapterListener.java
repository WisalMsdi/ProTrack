package tn.esprit.achraf.entity;

public interface ReunionAdapterListener {
    void OnUpdate(Reunion reunion);
    void OnDelete(int id,int pos);
}
