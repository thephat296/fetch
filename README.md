## Fetch Rewards App
This app retrieves a list of rewards from https://fetch-hiring.s3.amazonaws.com/hiring.json and displays them to users according to these rules:
* The rewards are grouped by their "listId."
* They are displayed in a sorted order, first by "listId" and then by "name."
* Any items without a name are left out.

## Screenshots
![rewards_1](https://github.com/thephat296/fetch/assets/30050797/df5bff35-3c49-4736-8ece-f9fd1cb4070b)
![rewards_2](https://github.com/thephat296/fetch/assets/30050797/8eb63ae7-28d9-4908-b40a-0fc0acc9fde8)


## Architecture
The **Fetch Rewards** app follows the [official architecture guidance](https://developer.android.com/topic/architecture).

Key technologies and libraries:
* **Kotlin Coroutines and Flow**: manage asynchronous operations efficiently, ensure smooth user experiences.
* **Hilt**: dependency injection
* **ViewModel**: stores and manage UI-related data
* **StateFlow**: helps in propagating changes in a reactive and efficient manner
* **ViewBinding**: binds UI components in the layout files to the corresponding views in code
* **Repository and Remote Data Source**: employs Retrofit and Gson to interact with remote data sources and retrieve data efficiently.
* **UseCase**: A dedicated UseCase is implemented to fetch rewards from the Data and handle business logic according to predefined rules, promoting a clear separation of concerns.

## Usage
1. Open Android Studio.
2. Navigate to File > New > Project From Version Control > Git.
3. In the URL field, input `git@github.com:thephat296/fetch.git`.

## License
```
MIT License

Copyright (c) 2023 thephat296

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
