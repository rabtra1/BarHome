# BarHome

## How can u get API token
you need to follow the link
> https://oauth.yandex.ru/authorize?response_type=token&client_id= ur client_id

And you will see ur api token.

## How can u get scenario id

You need to use any program to send requests (I did it through Postman) to send a request through this link
> https://api.iot.yandex.net/v1.0/user/info

With header
>Authorization: Bearer YOUR_API_TOKEN

You can make such a request via **curl**
> curl -i -X GET 'https://api.iot.yandex.net/v1.0/user/info' \
-H 'Authorization: Bearer YOUR_API_TOKEN'

And you will get json file, there you can find your scenarios id

> to get all the scripts at once, I wrote a program that lies in resources/program
