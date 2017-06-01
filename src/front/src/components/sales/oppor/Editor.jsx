import React from 'react'
import LeadsFrom from '../../public/LeadsFrom'
import DialogTips from '../../../utils/DialogTips'
import { leadsSources, leadsStages, leadsStatus, genderList, relationList, mktActList, opporAdd, opporQuery } from '../../../utils/api'

export default class Editor extends React.Component {
    constructor(props) {
        super(props)

        this.state = { option: null }
    }

    componentDidMount() {
        if (this.props.org) {
            this.dataInit(this.props.org.id)
        }
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.org) {
            if (!this.props.org || this.props.org.id !== nextProps.org.id) {
                this.dataInit(nextProps.org.id)
            }
        }
    }

    dataInit(oid) {
        const loading = DialogTips({ type: 'loading' })

        loading.open()
        $.when(
            mktActList(oid),
            leadsSources(2),
            leadsStages(2),
            leadsStatus(2),
            genderList(),
            relationList()
        ).done((act, sources, stages, status, gender, relation) => {
            this.setState({
                option: {
                    act,
                    sources,
                    stages,
                    status,
                    gender,
                    relation
                }
            })

            if (this.props.params.id !== 'create') {
                opporQuery(this.props.params.id)
                    .done((data) => {

                    })
                    .always(() => {
                        loading.close()
                    })
            } else {
                loading.close()
            }
        }).fail(() => {
            loading.close()
        })
    }

    formSubmit(query) {
        const successPath = SCHOOLPAL_CONFIG.ROOTPATH + 'crm/sales/oppor';
        const loading = DialogTips({ type: 'loading' })
        const success = DialogTips({ type: 'success' })
        const fail = DialogTips({ type: 'fail', autoClose: true })

        query.orgnizationId = this.props.org.id;
        loading.open()

        if (this.props.params.id !== 'create') {

        } else {
            opporAdd(query)
                .done((data) => {
                    loading.close()
                    success.open()
                    setTimeout(() => {
                        success.close()
                        this.props.router.push(successPath + '/edit/' + data)
                    }, 2000)
                })
                .fail((data) => {
                    loading.close()
                    fail.open()
                })
        }
    }

    render() {
        return (
            <div className="market">
                <LeadsFrom
                    title='销售机会'
                    subTitle='新建销售机会'
                    option={this.state.option ? this.state.option : null}
                    linkedId={this.props.params.id}
                    submit={this.formSubmit}
                />
            </div>
        )
    }
}