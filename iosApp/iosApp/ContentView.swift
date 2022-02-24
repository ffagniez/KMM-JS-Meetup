import SwiftUI
import shared

struct ContentView: View {

    var viewModel: CharactersViewModel

    @State var characters: [RickAndMortyCharacter] = NSArray() as! [RickAndMortyCharacter]

    func load() {
        viewModel.getFirstPage()
    }

    init() {
        viewModel = CharactersViewModel() { result in

        }
    }

	var body: some View {
        if(characters.count == 0) {
            Text("Loading").onAppear() {
                load()
            }
        } else {
            CharactersList(characters: characters)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
