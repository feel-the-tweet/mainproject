package feelthetweet.model.resources.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import feelthetweet.model.google.drive.FileItem;
import feelthetweet.model.google.drive.Files;
import feelthetweet.model.resource.GoogleDriveResource;

/* Pruebas automatizadas recursos Google Drive MASHUP*/

public class GoogleDriveResourceTest {
	static FileItem file1,file2,file3,file4;
	static Files files;
	static String id1,id2,id3,id4;
	
	/* Se necesita un access token para poder autentificar las llamadas, para obtenerlo debe acceder a la lista de archivos
	 * y hacer click en "See drive token". Cópielo en la variable access_token.
	 */
	static String access_token = "---";
	static GoogleDriveResource gdr = new GoogleDriveResource(access_token);
	
	@BeforeClass
	public static void setUp() throws Exception {
		file1 = new FileItem();
		file1.setTitle("Archivo 1");
		file2 = new FileItem();
		file2.setTitle("Archivo 2");
		file3 = new FileItem();
		file3.setTitle("Archivo 3");
		file4 = new FileItem();
		file4.setTitle("Archivo 4");
		
		id1 = gdr.insertFile(file1, "Content1");
		id2 = gdr.insertFile(file2, "Content2");
		id3 = gdr.insertFile(file3, "Content3");
		id4 = gdr.insertFile(file4, "Content4");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		gdr.deleteFile(id1);
		gdr.deleteFile(id2);
		gdr.deleteFile(id3);
	}
	
	@Test
	public void testGetFiles() {
		files = gdr.getFiles();
		
		assertNotNull("The collection of files is null", files.getItems());
		
		// Show result
		System.out.println("Listing all files:");
		int i=1;
		for (FileItem file : files.getItems()) {
			System.out.println("File " + i++ + " : " + file.getTitle() + " (ID=" + file.getId() + ")");
		}
		
	}
	
	@Test
	public void testGetFile() {
		FileItem f = gdr.getFile(id1);

		assertEquals("The name of the files do not match", f.getTitle(), file1.getTitle());
		
		// Show result
		System.out.println("File id: " +  f.getId());
		System.out.println("File name: " +  f.getTitle());

	}
	
	@Test
	public void testInsertFile() {
		FileItem f = new FileItem();
		f.setTitle("Archivo prueba insertado");
		String content = "Contenido del archivo";
		
		String fileId = gdr.insertFile(f, content);

		assertNotNull("Error when adding the file", fileId);
		assertEquals("The name of the files do not match", f.getTitle(), gdr.getFile(fileId).getTitle());
		
		// Show result
		System.out.println("File id: " +  fileId);
		System.out.println("File name: " +  gdr.getFile(fileId).getTitle());
		if(fileId!=null){
			gdr.deleteFile(fileId);
			System.out.println("File created and deleted");
		}

	}
	
	@Test
	public void testUpdateFileContent() {
		boolean success = gdr.updateFileContent(id3, "Nuevo contenido");
		
		assertTrue("Error when updating the file content", success);

		if(success){
			System.out.println("File content updated");
		}
	}
	
	@Test
	public void testDeleteFile() {
		boolean success = gdr.deleteFile(id4);
		assertTrue("Error when deleting the file", success);
		
		FileItem f = gdr.getFile(id4);
		assertNull("The file has not been deleted correctly", f);
		if(success){
			System.out.println("File deleted");
		}
	}

}
