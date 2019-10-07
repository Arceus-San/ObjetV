package fr.ubordeaux.ao;

import java.util.Set;

import fr.ubordeaux.ao.CatalogImpl;

public interface Catalog {
    public int size();
    public Set<Reference> getOwnReferences();
    public Set<Reference> getAllReferences();
    public Reference findReferenceById(String id);
    public void addReference(Reference reference);
    public void removeReference(Reference reference);
    public void addBrother(CatalogImpl catalogue);
}
