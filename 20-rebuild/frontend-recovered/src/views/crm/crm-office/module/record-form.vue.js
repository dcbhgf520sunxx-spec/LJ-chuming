import { useStore as ie } from "vuex";
import { computed as G } from "vue";
import { watch as ge } from "vue";
import { ref as d } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as ne } from "vue";
import { createVNode as w } from "vue";
import { withCtx as m } from "vue";
import { unref as o } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as A } from "vue";
import { createCommentVNode as b } from "vue";
import { createElementVNode as oe } from "vue";
import { ElMessage as Ee } from "element-plus";
import { ElTag as Fe } from "element-plus";
import { ElInput as De } from "element-plus";
import { dC as S, u as Ne, m as _e, lO as j, dA as i, lI as he, lv as re, G as Ae, L as Oe, lV as Pe } from "../../../../shared/runtime.js";
import { u as Ve, m as Se, n as je, o as Ge, p as Me, q as ke, s as Le } from "../../../../modules/use-form-data-13311836.js";
import { p as Ke } from "../../../../modules/project-information-053c195b.js";
import { u as Ue } from "../../../../modules/use-crm-basics-c35b230b.js";
import { u as xe } from "../../../../modules/use-crm-user-tree-f2f683a5.js";
import { u as Be } from "../../../../modules/use-crm-project-information-18afe991.js";
import We from "../components/firm-information-dialog.vue.js";
import ze from "../components/form-box.vue.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
const Je = (n) => {
  const p = ie(), y = G(() => p.state.crm.allProjectLoaded);
  if (y.value || p.dispatch("crm/fetchProjectAllList"), n) {
    const e = ge(y, (g) => {
      g && setTimeout(() => {
        n(), e();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: y, crmAllProjectList: G(() => p.state.crm.allProjectList) };
}, qe = { key: 1 }, He = { style: { float: "right" } }, $e = { class: "head-container" }, st = { __name: "record-form", props: { modelValue: { type: Boolean, default: void 0 }, title: { type: String, default: void 0 }, tabType: { type: String, default: void 0 }, isAdd: { type: Boolean, default: true }, currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success"], setup(n, { emit: p }) {
  const y = ie(), e = n, g = p, u = d(S.DOMESTIC.V), { formItemList: ue, serchFormDetail: se, fetchFormItemList: le, submitForm: de, submitEditForm: me, fetchFormDetail: ce } = Ve(), { visible: fe, handleClose: M } = Ne({ emit: g, props: e, showHook: Re }), { basicsConfigMap: k } = Ue(), { userTree: ve } = xe(), { sectionTree: pe } = Se(), { projectInformationMap: L } = Be(), { tenderConfigMap: K } = je(), { crmAllProjectList: ye } = Je(), { user: c } = _e("user"), f = d(), I = d(), O = d(false), U = d({}), t = d({}), P = d(false), Ie = G(() => !e.isAdd && (e.currentRow.crmCheckStatusEnum === j.NOT_PASS.V || e.currentRow.crmCheckStatusEnum === j.UNDER_REVIEW.V) || e.isAdd);
  async function Re() {
    var r, a;
    e.isAdd ? (e.tabType === i.FIRM_RECORD_CONFIG.K || e.tabType === i.PROJECT_SIGN_IN_CONFIG.K ? u.value = S.DOMESTIC.V : u.value = void 0, await E()) : (await E(), (e.tabType === i.FIRM_RECORD_CONFIG.K || e.tabType === i.PROJECT_SIGN_IN_CONFIG.K) && ((r = t.value) != null && r.crmCountryTypeEnum) ? u.value = (a = t.value) == null ? void 0 : a.crmCountryTypeEnum : u.value = void 0, await E()), console.log(L.value, k.value, K.value, t.value, "firmData.value");
  }
  async function E() {
    var a, F, D, R, N, _, s, l, C, T, x, B, W, z, J, q, H, $, Q, X, Y, Z, ee, te, ae;
    t.value = {};
    let r = [];
    r = await he(), e.isAdd ? (t.value = { informantUserId: c.value.id, informantDateTime: (/* @__PURE__ */ new Date()).getTime(), departmentId: c.value.deptId }, e.title === "任务认领" && (t.value.crmProjectInformationWarehousingId = ((N = e.currentRow) == null ? void 0 : N.crmProjectInformationWarehousingId) || void 0, P.value = !!((_ = e.currentRow) != null && _.crmProjectInformationWarehousingId), console.log(e.currentRow, P.value, "props.currentRow"), t.value.crmEnterpriseWarehousingId = ((s = e.currentRow) == null ? void 0 : s.crmEnterpriseWarehousingId) || void 0, t.value.unitPropertyAllocationConfigId = ((l = e.currentRow) == null ? void 0 : l.unitPropertyAllocationConfigId) || void 0, t.value.address = ((C = e.currentRow) == null ? void 0 : C.address) || void 0, t.value.unitClassConfigurationId = ((T = e.currentRow) == null ? void 0 : T.unitClassConfigurationId) || void 0, t.value.attachmentIds = ((x = e.currentRow) == null ? void 0 : x.attachmentDTOS) || ((B = e.currentRow) == null ? void 0 : B.attachmentIds) || void 0, t.value.biddingPlatformName = ((W = e.currentRow) == null ? void 0 : W.biddingPlatformName) || void 0, t.value.reasonForRegistration = ((z = e.currentRow) == null ? void 0 : z.reasonForRegistration) || void 0, t.value.regionList = ((J = e.currentRow) == null ? void 0 : J.regionList) || void 0, t.value.creditCode = ((q = e.currentRow) == null ? void 0 : q.creditCode) || void 0, t.value.crmProjectInformationWarehousingId = ((H = e.currentRow) == null ? void 0 : H.crmProjectInformationWarehousingId) || void 0, t.value.qualificationAndAbility = (($ = e.currentRow) == null ? void 0 : $.qualificationAndAbility) || void 0, t.value.businessPhone = ((Q = e.currentRow) == null ? void 0 : Q.businessPhone) || void 0, t.value.businessEmail = ((X = e.currentRow) == null ? void 0 : X.businessEmail) || void 0, t.value.liaisons = ((Y = e.currentRow) == null ? void 0 : Y.liaisons) || void 0, t.value.industryConfigurationId = ((Z = e.currentRow) == null ? void 0 : Z.industryConfigurationId) || void 0, t.value.id = ((ee = e.currentRow) == null ? void 0 : ee.id) || void 0), await ((te = f.value.initFormRef) == null ? void 0 : te.resetFields())) : (await ce({ params: e.currentRow, tabType: e.tabType, countryType: u.value }), t.value = se.value, t.value.informantUserId = ((a = t.value) == null ? void 0 : a.informantUserId) || c.value.id, t.value.informantDateTime = Number((F = t.value) == null ? void 0 : F.informantDateTime) || (/* @__PURE__ */ new Date()).getTime(), t.value.departmentId = ((D = t.value) == null ? void 0 : D.departmentId) || c.value.deptId, t.value.projectAttachments = ((R = t.value) == null ? void 0 : R.projectAttachmentList) || void 0), await le({ recordEnum: i[e == null ? void 0 : e.tabType].V, basicsConfigMap: k.value, user: ve.value, section: pe.value, projectInformation: L.value, tenderApplicationMap: K.value, allProjectList: ye.value, esayFirmList: r, currentRow: e.currentRow, countryType: u.value }), await ((ae = f.value.initFormRef) == null ? void 0 : ae.clearValidate());
  }
  async function Ce() {
    try {
      const r = await Pe({ companyNameOrCreditCode: I.value });
      U.value = r, O.value = true;
    } catch (r) {
      console.log(r, "获取信息");
    }
  }
  function Te(r) {
    t.value = r, I.value = void 0, t.value.informantUserId = c.value.id, t.value.informantDateTime = (/* @__PURE__ */ new Date()).getTime(), t.value.departmentId = c.value.deptId;
  }
  async function we() {
    if (console.log(f.value, "drawerFormRef.value"), !await f.value.validateForm()) return;
    const a = { ...f.value.submitData, crmCheckStatusEnum: j.BE_IN_STORAGE.V };
    e.isAdd ? await de({ tabType: e.tabType, formData: a, countryType: u.value }) : await me({ tabType: e.tabType, formData: a, countryType: u.value }), Ee.success("提交成功"), console.log(a, "form 12344"), await y.dispatch("approval_list/fetchApprovalNum"), g("success"), M();
  }
  async function be(r) {
    u.value = r, await E();
  }
  return (r, a) => {
    const F = Fe, D = De, R = V("common-button"), N = V("common-radio-button"), _ = V("common-drawer");
    return v(), ne("div", null, [w(_, { title: e.title, "close-on-click-modal": false, "destroy-on-close": "", visible: o(fe), size: "100%", "before-close": o(M) }, { titleAfter: m(() => {
      var s;
      return [((s = n.currentRow) == null ? void 0 : s.crmProjectScheduleTypeEnum) === o(re).FINISH.V ? (v(), h(F, { key: 0, type: "danger", effect: "plain", style: { "margin-right": "15px" } }, { default: m(() => a[3] || (a[3] = [A(" 项目已终止 ")])), _: 1, __: [3] })) : b("", true), e.tabType === o(i).FIRM_RECORD_CONFIG.K && n.isAdd ? (v(), ne("div", qe, [w(D, { placeholder: "请输入企业名称/社会统一信用代码查询", modelValue: I.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => I.value = l), style: { width: "270px", "margin-right": "10px" } }, null, 8, ["modelValue"]), w(R, { size: "default", type: "warning", onClick: Ce, disabled: !I.value }, { default: m(() => a[4] || (a[4] = [A(" 企业信息查询 ")])), _: 1, __: [4] }, 8, ["disabled"])])) : b("", true)];
    }), titleRight: m(() => {
      var s, l, C, T;
      return [Ie.value ? (v(), h(R, { key: 0, disabled: ((s = n.currentRow) == null ? void 0 : s.crmProjectScheduleTypeEnum) === o(re).FINISH.V, type: "success", size: "default", style: { float: "right" }, onClick: we }, { default: m(() => a[5] || (a[5] = [A(" 保存 ")])), _: 1, __: [5] }, 8, ["disabled"])) : b("", true), oe("div", He, [!n.isAdd && ((l = n.permission) != null && l.export) && o(Ae)((C = n.permission) == null ? void 0 : C.export) ? (v(), h(Oe, { key: 0, fn: n.tabType === o(i).FIRM_RECORD_CONFIG.K ? o(Ge) : n.tabType === o(i).PROJECT_SIGN_IN_CONFIG.K ? o(Ke) : n.tabType === o(i).GOVERNMENT_RECORD_CONFIG.K ? o(Me) : n.tabType === o(i).PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K ? o(ke) : n.tabType === o(i).SUPPLIER_INTO_RECORD_CONFIG.K ? o(Le) : "", params: { id: (T = n.currentRow) == null ? void 0 : T.id }, size: "default", class: "filter-item" }, { default: m(() => a[6] || (a[6] = [A(" 下载 ")])), _: 1, __: [6] }, 8, ["fn", "params"])) : b("", true)])];
    }), content: m(() => [oe("div", $e, [n.tabType === o(i).FIRM_RECORD_CONFIG.K || n.tabType === o(i).PROJECT_SIGN_IN_CONFIG.K ? (v(), h(N, { key: 0, modelValue: u.value, "onUpdate:modelValue": a[1] || (a[1] = (s) => u.value = s), options: o(S).ENUM, class: "filter-item disabled-country-type", size: "default", type: "enum", disabled: !n.isAdd, onChange: be }, null, 8, ["modelValue", "options", "disabled"])) : b("", true)]), w(ze, { ref_key: "drawerFormRef", ref: f, "form-item-list": o(ue), isAdd: n.isAdd, "firm-data": t.value, isProjectId: P.value, "tab-type": e.tabType, countryType: u.value }, null, 8, ["form-item-list", "isAdd", "firm-data", "isProjectId", "tab-type", "countryType"])]), _: 1 }, 8, ["title", "visible", "before-close"]), w(We, { modelValue: O.value, "onUpdate:modelValue": a[2] || (a[2] = (s) => O.value = s), information: U.value, onSuccess: Te }, null, 8, ["modelValue", "information"])]);
  };
} };
export {
  st as default
};
