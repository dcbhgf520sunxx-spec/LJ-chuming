<script setup>
import { computed, onMounted, reactive, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { ElAlert, ElButton, ElCard, ElColorPicker, ElDialog, ElEmpty, ElForm, ElFormItem, ElInput, ElInputNumber, ElLoading, ElMessage, ElMessageBox, ElOption, ElPagination, ElRadioButton, ElRadioGroup, ElSelect, ElTable, ElTableColumn, ElTag } from 'element-plus'
const vLoading = ElLoading.directive
import { session } from '../session.js'
import { canResource, fromProductionLine, productTypes, resourceApi, workshopTypes } from '../resource-business.js'
const props = defineProps({ mode: { type: String, default: 'factories' } })
const route = useRoute(), router = useRouter()
const optionsError = ref('')
const selectedFactory = ref(null), factories = ref([]), workshops = ref([]), branches = ref([])
const formRef = ref(), dialog = ref(false), saving = ref(false), formError = ref(''), kind = ref('workshop'), form = reactive({})
const names = { factory: '工厂', workshop: '车间', productionLine: '生产线' }
const state = reactive(Object.fromEntries(Object.keys(names).map(key => [key, { rows: [], total: 0, page: 1, size: 10, loading: false, error: '', request: 0 }])))
const factoryQuery = reactive({ name: '', boolEnabledEnum: true })
const workshopQuery = reactive({ name: '', boolEnabledEnum: true })
const lineQuery = reactive({ name: '', boolEnabledEnum: true, factoryId: route.query.factoryId || undefined, workshopId: route.query.workshopId || undefined, productType: undefined, mesProductEnum: session.user?.mesProductEnum?.[0] })
const allowedWorkshopTypes = computed(() => workshopTypes.filter(t => (session.user?.factoryProductEnum || []).includes(t.value)))
const allowedMesTypes = computed(() => [{ value: 1, label: '建钢' }, { value: 2, label: '桥梁' }].filter(t => (session.user?.mesProductEnum || []).includes(t.value)))
const allowedWorkshops = computed(() => workshops.value.filter(w => !lineQuery.factoryId || String(w.factoryId) === String(lineQuery.factoryId)))
const permitted = (resource, operation) => canResource(session.user, resource, operation)
function queryFor(resource) {
  if (resource === 'factory') return factoryQuery
  if (resource === 'workshop') return { ...workshopQuery, factoryId: selectedFactory.value?.id }
  return lineQuery
}
async function load(resource, reset = false) {
  const record = state[resource]
  if (reset) record.page = 1
  if (resource === 'workshop' && !selectedFactory.value) return
  const version = ++record.request
  record.loading = true; record.error = ''
  try {
    const data = await resourceApi.page(resource, { ...queryFor(resource), pageNumber: record.page, pageSize: record.size })
    if (version !== record.request) return
    if (!Array.isArray(data?.content) || !Number.isFinite(data?.totalElements)) throw new Error('列表返回格式异常')
    record.rows = data.content; record.total = data.totalElements
    if (resource === 'factory' && selectedFactory.value) {
      const current = data.content.find(row => String(row.id) === String(selectedFactory.value.id))
      if (current) selectedFactory.value = current
    }
  } catch (e) { if (version === record.request) { record.error = e.message; record.rows = []; record.total = 0 } }
  finally { if (version === record.request) record.loading = false }
}
async function loadOptions() {
  const [factoryData, workshopData] = await Promise.all([resourceApi.list('factory', { boolEnabledEnum: true }), resourceApi.list('workshop', { boolEnabledEnum: true, type: lineQuery.mesProductEnum })])
  if (!Array.isArray(factoryData?.content) || !Array.isArray(workshopData?.content)) throw new Error('工厂或车间选项返回格式异常')
  factories.value = factoryData.content; workshops.value = workshopData.content
  // URL values are strings; preserve the exact ID type used by the options.
  lineQuery.factoryId = factories.value.find(item => String(item.id) === String(lineQuery.factoryId))?.id ?? lineQuery.factoryId
  lineQuery.workshopId = workshops.value.find(item => String(item.id) === String(lineQuery.workshopId))?.id ?? lineQuery.workshopId
}
function chooseFactory(row) { if (row) { selectedFactory.value = row; load('workshop', true) } }
async function filterLines() { await load('productionLine', true) }
async function reloadLines(reset = false) {
  optionsError.value = ''
  try { await loadOptions() } catch (e) { optionsError.value = e.message }
  await load('productionLine', reset)
}
async function changeMes() { lineQuery.workshopId = undefined; await reloadLines(true) }
function changeFactory() { lineQuery.workshopId = undefined; filterLines() }
async function showForm(resource, row) {
  kind.value = resource; formError.value = ''
  Object.keys(form).forEach(key => delete form[key])
  Object.assign(form, resource === 'productionLine' ? { workshopId: lineQuery.workshopId, productType: undefined, ton: undefined, name: '', remark: '', mesProductEnum: lineQuery.mesProductEnum } : { name: '', shortName: '', sort: 1, remark: '', factoryId: selectedFactory.value?.id, type: allowedWorkshopTypes.value[0]?.value, ton: undefined, tagColor: '#1682e6' })
  if (row) Object.assign(form, resource === 'productionLine' ? fromProductionLine(row, lineQuery.mesProductEnum) : row)
  dialog.value = true
  if (resource === 'factory') {
    try { const data = await resourceApi.branches(); if (!Array.isArray(data?.content)) throw new Error('分支机构返回格式异常'); branches.value = data.content }
    catch (e) { formError.value = e.message }
  }
  formRef.value?.clearValidate()
}
const rules = computed(() => ({
  name: [{ required: true, message: `请填写${names[kind.value]}名称`, trigger: 'blur' }, { min: 1, max: 32, message: '长度在 1 到 32 个字符', trigger: 'blur' }],
  shortName: [{ required: kind.value === 'factory', message: '请填写工厂简称', trigger: 'blur' }, { min: 1, max: 32, message: '长度在 1 到 32 个字符', trigger: 'blur' }],
  branchCompanyId: [{ required: true, message: '请选择分支机构', trigger: 'change' }],
  workshopId: [{ required: true, message: '请选择车间', trigger: 'change' }],
  productType: [{ required: true, message: '请选择产品类型', trigger: 'change' }],
  type: [{ required: true, message: '请选择车间类型', trigger: 'change' }],
  ton: [{ required: true, type: 'number', message: '请填写目标产量', trigger: 'blur' }],
  sort: [{ required: true, type: 'number', message: '请填写排序值', trigger: 'blur' }],
  remark: [{ max: 500, message: '不能超过 500 个字符', trigger: 'blur' }],
}))
async function save() {
  if (saving.value) return
  try { await formRef.value.validate() } catch { return }
  saving.value = true; formError.value = ''
  try {
    await resourceApi.save(kind.value, form)
    dialog.value = false; ElMessage.success('保存成功')
    if (kind.value === 'productionLine') await reloadLines()
    else await load(kind.value)
  } catch (e) { formError.value = e.message } finally { saving.value = false }
}
async function changeState(resource, row) {
  const enabled = !row.boolEnabledEnum
  try {
    await ElMessageBox.confirm(`此操作将 "${enabled ? '启用' : '禁用'}" ${row.name}, 是否继续？`, '提示', { type: 'warning', confirmButtonText: '确定', cancelButtonText: '取消' })
    await resourceApi.state(resource, row.id, enabled)
    await load(resource)
    if (props.mode === 'lines') { optionsError.value = ''; try { await loadOptions() } catch (e) { optionsError.value = e.message } }
    ElMessage.success(`${enabled ? '启用' : '禁用'}成功`)
  } catch (e) { if (e !== 'cancel' && e !== 'close') ElMessage.error(e.message || '状态变更失败') }
}
async function remove(resource, row) {
  try {
    await ElMessageBox.confirm(`确定删除${names[resource]}“${row.name}”？`, '提示', { type: 'warning', confirmButtonText: '删除', cancelButtonText: '取消' })
    await resourceApi.remove(resource, row.id)
    if (state[resource].rows.length === 1 && state[resource].page > 1) state[resource].page--
    await load(resource)
    if (resource === 'factory' && String(selectedFactory.value?.id) === String(row.id)) { selectedFactory.value = null; state.workshop.request++; state.workshop.rows = []; state.workshop.total = 0; state.workshop.loading = false }
    if (props.mode === 'lines') { optionsError.value = ''; try { await loadOptions() } catch (e) { optionsError.value = e.message } }
    ElMessage.success('删除成功')
  } catch (e) { if (e !== 'cancel' && e !== 'close') ElMessage.error(e.message || '删除失败') }
}
function openLines(row) { router.push({ path: '/mes/production-config/production-line/index', query: { factoryId: selectedFactory.value.id, workshopId: row.id } }) }
onMounted(async () => {
  if (props.mode === 'factories') await load('factory')
  else await reloadLines()
})
</script>
<template>
  <section class="resource-business">
    <div v-if="mode === 'factories'" class="factory-workshop-grid">
      <el-card v-for="resource in ['factory', 'workshop']" :key="resource" shadow="never">
        <template #header><div class="resource-card-heading"><strong>{{ names[resource] }}列表</strong><el-tag v-if="resource === 'workshop' && selectedFactory" type="success">{{ selectedFactory.name }}</el-tag><el-button v-if="permitted(resource, 'add')" type="primary" :disabled="resource === 'factory' ? state.factory.rows.length === 1 : !selectedFactory" @click="showForm(resource)">新增</el-button></div></template>
        <el-empty v-if="resource === 'workshop' && !selectedFactory" description="点击工厂查看详情" />
        <template v-else>
          <div class="resource-filters"><el-select v-model="(resource === 'factory' ? factoryQuery : workshopQuery).boolEnabledEnum" aria-label="状态筛选" clearable placeholder="全部状态" @change="load(resource, true)"><el-option label="启用" :value="true"/><el-option label="禁用" :value="false"/></el-select><el-input v-model.trim="(resource === 'factory' ? factoryQuery : workshopQuery).name" :placeholder="`输入${names[resource]}名称搜索`" clearable @keyup.enter="load(resource, true)"/><el-button @click="load(resource, true)">查询</el-button></div>
          <el-alert v-if="state[resource].error" :title="state[resource].error" type="error" :closable="false" show-icon />
          <el-table v-loading="state[resource].loading" :data="state[resource].rows" row-key="id" highlight-current-row @row-click="resource === 'factory' && chooseFactory($event)" empty-text="暂无数据">
            <el-table-column type="index" label="序号" width="60"/>
            <el-table-column v-if="resource === 'factory'" prop="branchCompanyName" label="分支机构" min-width="130" show-overflow-tooltip/>
            <el-table-column prop="name" :label="`${names[resource]}名称`" min-width="140" show-overflow-tooltip/>
            <el-table-column prop="shortName" label="简称" min-width="100"/>
            <el-table-column v-if="resource === 'workshop'" label="车间类型" width="100"><template #default="{row}">{{ workshopTypes.find(t => t.value === row.type)?.label || row.type }}</template></el-table-column>
            <el-table-column v-if="resource === 'workshop'" prop="ton" label="目标产量(吨)" width="120"/>
            <el-table-column label="状态" width="105"><template #default="{row}"><el-button :type="row.boolEnabledEnum ? 'success' : 'danger'" plain size="small" :disabled="!permitted(resource, 'editStatus')" @click.stop="changeState(resource,row)">{{ row.boolEnabledEnum ? '启用' : '禁用' }}</el-button></template></el-table-column>
            <el-table-column prop="sort" label="排序" width="65"/>
            <el-table-column prop="remark" label="备注" min-width="140" show-overflow-tooltip/>
            <el-table-column label="操作" :width="resource === 'workshop' ? 205 : 125" fixed="right"><template #default="{row}"><el-button v-if="permitted(resource,'edit')" link type="primary" @click.stop="showForm(resource,row)">编辑</el-button><el-button v-if="resource === 'workshop' && permitted('productionLine','get')" link type="primary" @click.stop="openLines(row)">生产线</el-button><el-button v-if="permitted(resource,'del')" link type="danger" @click.stop="remove(resource,row)">删除</el-button></template></el-table-column>
          </el-table>
          <el-pagination v-model:current-page="state[resource].page" :page-size="state[resource].size" :total="state[resource].total" layout="total, prev, pager, next" @current-change="load(resource)" />
        </template>
      </el-card>
    </div>
    <el-card v-else shadow="never">
      <template #header><div class="resource-card-heading"><strong>生产线列表</strong><el-button v-if="permitted('productionLine','add')" type="primary" @click="showForm('productionLine')">新增</el-button></div></template>
      <div class="resource-filters"><el-radio-group v-model="lineQuery.mesProductEnum" aria-label="构件类型" @change="changeMes"><el-radio-button v-for="item in allowedMesTypes" :key="item.value" :value="item.value">{{ item.label }}</el-radio-button></el-radio-group><el-select v-model="lineQuery.boolEnabledEnum" aria-label="生产线状态筛选" clearable placeholder="全部状态" @change="filterLines"><el-option label="启用" :value="true"/><el-option label="禁用" :value="false"/></el-select><el-select v-model="lineQuery.factoryId" clearable filterable placeholder="选择工厂搜索" @change="changeFactory"><el-option v-for="item in factories" :key="item.id" :label="item.name" :value="item.id"/></el-select><el-select v-model="lineQuery.workshopId" clearable filterable placeholder="选择车间搜索" @change="filterLines"><el-option v-for="item in allowedWorkshops" :key="item.id" :label="item.name" :value="item.id"/></el-select><el-select v-model="lineQuery.productType" clearable placeholder="产品类型" @change="filterLines"><el-option v-for="item in productTypes" :key="item.value" :label="item.label" :value="item.value"/></el-select><el-input v-model.trim="lineQuery.name" clearable placeholder="输入生产线名称搜索" @keyup.enter="filterLines"/><el-button @click="filterLines">查询</el-button></div>
      <el-alert v-if="optionsError" :title="`工厂/车间选项加载失败：${optionsError}`" type="error" :closable="false" show-icon><el-button link type="primary" @click="reloadLines()">重新加载</el-button></el-alert>
      <el-alert v-if="state.productionLine.error" :title="state.productionLine.error" type="error" :closable="false" show-icon/>
      <el-table v-loading="state.productionLine.loading" :data="state.productionLine.rows" row-key="id" empty-text="暂无数据">
        <el-table-column type="expand"><template #default="{row}"><div class="line-detail">工厂：{{ row.factoryName }}　车间：{{ row.workshopName }}<p>备注：{{ row.remark }}</p></div></template></el-table-column><el-table-column type="index" label="序号" width="60"/><el-table-column prop="workshopName" label="车间名称" min-width="130"/><el-table-column prop="name" label="生产线名称" min-width="230"><template #default="{row}"><el-tag size="small">{{ productTypes.find(t => t.value === row.productType)?.label || row.productType }}</el-tag> {{ row.name }}</template></el-table-column><el-table-column label="目标产量(吨/月)" min-width="150"><template #default="{row}">{{ (Number(row.targetProduction || 0) / 1000).toFixed(2) }}</template></el-table-column><el-table-column label="状态" width="105"><template #default="{row}"><el-button :type="row.boolEnabledEnum ? 'success' : 'danger'" plain size="small" :disabled="!permitted('productionLine','editStatus')" @click="changeState('productionLine', row)">{{ row.boolEnabledEnum ? '启用' : '禁用' }}</el-button></template></el-table-column><el-table-column label="操作" width="125" fixed="right"><template #default="{row}"><el-button v-if="permitted('productionLine','edit')" type="primary" link @click="showForm('productionLine',row)">编辑</el-button><el-button v-if="permitted('productionLine','del')" type="danger" link @click="remove('productionLine',row)">删除</el-button></template></el-table-column>
      </el-table><el-pagination v-model:current-page="state.productionLine.page" :page-size="state.productionLine.size" :total="state.productionLine.total" layout="total, prev, pager, next" @current-change="load('productionLine')"/>
    </el-card>
    <el-dialog v-model="dialog" :title="`${form.id == null ? '新增' : '编辑'}${names[kind]}`" width="550px" :close-on-click-modal="false" :close-on-press-escape="!saving" :show-close="!saving">
      <el-alert v-if="formError" :title="formError" type="error" :closable="false" show-icon/>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="140px" :disabled="saving" @submit.prevent="save">
        <el-form-item v-if="kind === 'factory'" label="分支机构" prop="branchCompanyId"><el-select v-model="form.branchCompanyId" clearable filterable placeholder="请选择分支机构"><el-option v-for="branch in branches" :key="branch.id" :label="branch.name" :value="branch.id"/></el-select></el-form-item>
        <el-form-item v-if="kind === 'productionLine'" label="车间" prop="workshopId"><el-select v-model="form.workshopId" :disabled="form.id != null" filterable placeholder="请选择车间"><el-option v-if="form.id != null && !workshops.some(w => String(w.id) === String(form.workshopId))" :label="form.workshopName" :value="form.workshopId"/><el-option v-for="item in workshops" :key="item.id" :label="item.name" :value="item.id"/></el-select></el-form-item>
        <el-form-item :label="`${names[kind]}名称`" prop="name"><el-input v-model="form.name" maxlength="32"/></el-form-item>
        <el-form-item v-if="kind !== 'productionLine'" :label="`${names[kind]}简称`" prop="shortName"><el-input v-model.trim="form.shortName" maxlength="32"/></el-form-item>
        <el-form-item v-if="kind === 'factory'" label="标签颜色" prop="tagColor"><el-color-picker v-model="form.tagColor" show-alpha/></el-form-item>
        <el-form-item v-if="kind === 'workshop'" label="车间类型" prop="type"><el-select v-model="form.type" placeholder="请选择车间类型"><el-option v-for="item in allowedWorkshopTypes" :key="item.value" :label="item.label" :value="item.value"/></el-select></el-form-item>
        <el-form-item v-if="kind !== 'factory'" :label="kind === 'workshop' ? '目标产量(吨)' : '目标产量(吨/月)'" prop="ton"><el-input-number v-model="form.ton" :controls="false" :min="0" :max="999999999"/></el-form-item>
        <el-form-item v-if="kind === 'productionLine'" label="产品类型" prop="productType"><el-select v-model="form.productType" placeholder="请选择产品类型"><el-option v-for="item in productTypes" :key="item.value" :label="item.label" :value="item.value"/></el-select></el-form-item>
        <el-form-item v-else label="排序" prop="sort"><el-input-number v-model="form.sort" :min="1" :max="999" :step="1" step-strictly/></el-form-item>
        <el-form-item label="备注" prop="remark"><el-input v-model="form.remark" type="textarea" :rows="4" maxlength="500" show-word-limit/></el-form-item>
      </el-form><template #footer><el-button :disabled="saving" @click="dialog = false">取消</el-button><el-button type="primary" :loading="saving" @click="save">确认</el-button></template>
    </el-dialog>
  </section>
</template>
<style scoped>
.resource-business{padding:14px}.factory-workshop-grid{display:grid;grid-template-columns:1fr 1fr;gap:12px}.factory-workshop-grid>*{min-width:0}.resource-card-heading{display:flex;align-items:center;gap:12px}.resource-card-heading>button{margin-left:auto}.resource-filters{display:flex;align-items:center;gap:8px;flex-wrap:wrap;margin-bottom:14px}.resource-filters>.el-select,.resource-filters>.el-input{width:185px}.resource-filters>.el-select:first-child{width:115px}.el-pagination{margin-top:16px;justify-content:flex-end}.el-alert{margin-bottom:12px}.el-form{margin-top:16px}.el-form .el-select,.el-form .el-input-number{width:100%}.line-detail{padding:0 24px;color:#606266}@media(max-width:1250px){.factory-workshop-grid{grid-template-columns:1fr}}@media(max-width:680px){.resource-business{padding:4px}.resource-filters>.el-select,.resource-filters>.el-input{width:100%}:deep(.el-dialog){width:calc(100% - 20px)!important}.el-pagination{justify-content:center}}
</style>
