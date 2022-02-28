import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel: MyCharactersViewModel

    var body: some View {
        VStack {
            switch viewModel.state {
            case .loading, .idle:
                Text("Loading")
            case .ready:
                CharactersList(characters: $viewModel.fetchedCharacters) {
                    viewModel.getMoreCharacters()
                }
            case .error(let error):
                Text(error.localizedDescription)
            }
        }
        .onAppear {
            viewModel.initialize()
            viewModel.getFirstPage()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(viewModel: MyCharactersViewModel())
    }
}
