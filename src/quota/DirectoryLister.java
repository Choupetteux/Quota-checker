package quota;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryLister {
    private File startingDirectory;

    public DirectoryLister(String startingDirectoryPath) {
        this.startingDirectory = new File(startingDirectoryPath);
    }

    public Long list() {
        return recursiveList(startingDirectory, "");
    }

    public static void main(String[] args) {
        DirectoryLister lister = new DirectoryLister("/usr/share/icons");
        System.out.println(lister.list() / (1024 * 1024) + " Mio");
    }

    private long recursiveList(File file, String indent) {
/* MAUVAIS CODE ORIGINAL   	
 * //Si file est un fichier
    	if(file.isFile()){
    		System.out.println(indent + file.getName());
    		size = file.length();
    	}
    	//Si file est un dossier
    	else if(file.isDirectory()){
    		//Afficher nom répertoire courant
    		System.out.println(indent + "+ " + file.getName());
    	
    		//Filter les dossiers uniquement.
    		String[] directories = file.list(new FilenameFilter(){
    			@Override
    			public boolean accept(File current, String name){
    				return new File(current, name).isDirectory();
    			}
    		});
    		
    		//Filtrer les fichiers seulement
    		String[] files = file.list(new FilenameFilter(){
    			@Override
    			public boolean accept(File current, String name){
    				return new File(current, name).isFile();
    			}
    		});
    		
    		//Récursivité pour afficher les sous répertoires
    		for(int i = 0; i < directories.length; i++){
    			this.recursiveList(new File(file, directories[i]), indent + '\t');
    		}
    		//Afficher les fichiers dans ce répertoire
    		for(int j = 0; j < files.length; j++){
    			size = size + this.recursiveList(new File(file, files[j]), indent + '\t');
    		}
    	}*/
    	Long size = new Long(0);
    	if(file.isDirectory()){
			System.out.println(indent + "+ " + file.getName());
    		for(int i = 0; i < file.listFiles().length; i++){
    			size = size + recursiveList(file.listFiles()[i], indent + '\t');
    		}
    	}
    	else{
    		System.out.println(indent + file.getName());
    		size = file.length();
    	}
    	return size; 
    }
   
}
