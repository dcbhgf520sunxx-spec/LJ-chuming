import { ref as f } from "vue";
import { computed as We } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as b } from "vue";
import { createBlock as y } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { createElementBlock as Pe } from "vue";
import { Fragment as be } from "vue";
import { renderList as _e } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as L } from "vue";
import { createElementVNode as h } from "vue";
import { unref as P } from "vue";
import { createCommentVNode as A } from "vue";
import { ElMessageBox as je } from "element-plus";
import { ElMessage as Ve } from "element-plus";
import { ElCheckbox as Re } from "element-plus";
import { ElCheckboxGroup as Oe } from "element-plus";
import { ElFormItem as ye } from "element-plus";
import { ElForm as Fe } from "element-plus";
import { ElCard as Ne } from "element-plus";
import { ElInput as Ce } from "element-plus";
import { ElDatePicker as Te } from "element-plus";
import { ElTag as we } from "element-plus";
import { _ as Ae, u as Ge, bv as Me, dA as m, i as E, S as q } from "../../../../shared/runtime.js";
import { d as Se, h as ke, r as xe, i as B } from "../../../../modules/project-information-053c195b.js";
import z from "../components/UploadList.vue.js";
const De = { style: { display: "flex", "flex-wrap": "wrap" } }, Ue = { style: { display: "flex", "flex-wrap": "wrap" } }, Le = { style: { display: "flex", "flex-wrap": "wrap" } }, qe = { style: { display: "flex", "flex-wrap": "wrap" } }, Be = { __name: "assignment-drawer", props: { modelValue: { type: Boolean, default: void 0 }, projectOptions: { type: Array, default: () => [] }, simpleFirmOptions: { type: Array, default: () => [] }, simpleFirmMap: {} }, emits: ["update:modelValue", "success"], setup(N, { emit: Z }) {
  const v = N, H = Z, G = f(false), C = f(), T = f(), _ = f(), { visible: $, handleClose: K } = Ge({ emit: H, props: v, showHook: re }), ee = We(() => {
    const i = [];
    return Me.toArr(m).forEach((u) => {
      (m.GOVERNMENT_RECORD_CONFIG.V === u.V || m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V === u.V || m.SUPPLIER_INTO_RECORD_CONFIG.V === u.V) && i.push(u);
    }), i;
  }), W = f([]), j = f(false), V = f(false), R = f(false), J = f({}), Q = f({}), X = f({}), d = f([]), o = f({ boolProject: true, crmProjectInformationWarehousingId: void 0, crmEnterpriseWarehousingId: void 0, deadlineForAcceptanceTime: void 0, mediaTypeId: void 0, options: [], attachmentIds: void 0 }), n = f({ boolProject: true, crmEnterpriseWarehousingId: void 0, crmProjectInformationWarehousingId: void 0, biddingPlatformName: void 0, reasonForRegistration: void 0, options: [], attachmentIds: void 0 }), a = f({ boolProject: true, crmProjectInformationWarehousingId: void 0, mediaTypeId: void 0, crmEnterpriseWarehousingId: void 0, options: [], attachmentIds: void 0 }), M = f([{ name: "是", value: true }, { name: "否", value: false }]);
  function re() {
    o.value = { boolProject: true, crmProjectInformationWarehousingId: void 0, crmEnterpriseWarehousingId: void 0, mediaTypeId: void 0, options: [], attachmentIds: void 0 }, n.value = { boolProject: true, crmEnterpriseWarehousingId: void 0, crmProjectInformationWarehousingId: void 0, biddingPlatformName: void 0, reasonForRegistration: void 0, options: [], attachmentIds: void 0 }, a.value = { boolProject: true, crmProjectInformationWarehousingId: void 0, crmEnterpriseWarehousingId: void 0, deadlineForAcceptanceTime: void 0, mediaTypeId: void 0, options: [], attachmentIds: void 0 }, j.value = false, V.value = false, R.value = false, console.log(W.value, "selectValues"), W.value = [], ie();
  }
  const ae = { boolProject: [{ required: true, message: "请选择是否存在项目", trigger: "change" }], crmProjectInformationWarehousingId: [{ required: true, message: "请选择项目名称", trigger: "change" }], crmEnterpriseWarehousingId: [{ required: true, message: "请选择企业名称", trigger: "change" }], attachmentIds: [{ required: true, message: "请上传备案规定", trigger: "change" }] }, ne = { boolProject: [{ required: true, message: "请选择是否存在项目", trigger: "change" }], crmProjectInformationWarehousingId: [{ required: true, message: "请选择项目名称", trigger: "change" }], crmEnterpriseWarehousingId: [{ required: true, message: "请选择企业名称", trigger: "change" }], biddingPlatformName: [{ required: true, message: "请填写招标平台名称", trigger: "change" }], reasonForRegistration: [{ required: true, message: "请填写报名事由", trigger: "change" }], attachmentIds: [{ required: true, message: "请上传入库通知文件", trigger: "change" }] }, oe = { boolProject: [{ required: true, message: "请选择是否存在项目", trigger: "change" }], crmProjectInformationWarehousingId: [{ required: true, message: "请选择项目名称", trigger: "change" }], crmEnterpriseWarehousingId: [{ required: true, message: "请选择企业名称", trigger: "change" }], deadlineForAcceptanceTime: [{ required: true, message: "请选择受理截止日", trigger: "change" }], attachmentIds: [{ required: true, message: "请选择入库通知文件", trigger: "change" }] };
  async function ie() {
    try {
      (await Se()).forEach((e) => {
        e.crmPageManagementConfigEnum === m.GOVERNMENT_RECORD_CONFIG.V ? o.value.options.push(e) : e.crmPageManagementConfigEnum === m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V ? n.value.options.push(e) : a.value.options.push(e);
      });
    } catch (i) {
      console.log(i);
    }
  }
  function le(i) {
    i.includes(m.GOVERNMENT_RECORD_CONFIG.V) ? j.value = true : j.value = false, i.includes(m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V) ? V.value = true : V.value = false, i.includes(m.SUPPLIER_INTO_RECORD_CONFIG.V) ? R.value = true : R.value = false, console.log(i, "v");
  }
  function te(i) {
    var e, u, c, p;
    d.value = [], o.value.crmEnterpriseWarehousingId && (o.value.boolProject || S({ id: i, type: m.GOVERNMENT_RECORD_CONFIG.V }), o.value.crmProjectInformationWarehousingId && o.value.crmEnterpriseWarehousingId && o.value.crmProjectInformationWarehousingId === n.value.crmProjectInformationWarehousingId ? (n.value.crmEnterpriseWarehousingId = o.value.crmEnterpriseWarehousingId, d.value = (u = (e = v.simpleFirmOptions) == null ? void 0 : e.filter((r) => r.id !== o.value.crmEnterpriseWarehousingId)) == null ? void 0 : u.map((r) => r.id)) : o.value.crmProjectInformationWarehousingId && o.value.crmEnterpriseWarehousingId && a.value.crmProjectInformationWarehousingId === o.value.crmProjectInformationWarehousingId ? (a.value.crmEnterpriseWarehousingId = o.value.crmEnterpriseWarehousingId, d.value = (p = (c = v.simpleFirmOptions) == null ? void 0 : c.filter((r) => r.id !== o.value.crmEnterpriseWarehousingId)) == null ? void 0 : p.map((r) => r.id)) : d.value = []);
  }
  function se(i) {
    var e, u, c, p;
    a.value.crmEnterpriseWarehousingId && (a.value.boolProject || S({ id: i, type: m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V }), a.value.crmProjectInformationWarehousingId && a.value.crmEnterpriseWarehousingId && a.value.crmProjectInformationWarehousingId === o.value.crmProjectInformationWarehousingId ? (o.value.crmEnterpriseWarehousingId = a.value.crmEnterpriseWarehousingId, d.value = (u = (e = v.simpleFirmOptions) == null ? void 0 : e.filter((r) => r.id !== a.value.crmEnterpriseWarehousingId)) == null ? void 0 : u.map((r) => r.id)) : a.value.crmProjectInformationWarehousingId && a.value.crmEnterpriseWarehousingId && a.value.crmProjectInformationWarehousingId === n.value.crmProjectInformationWarehousingId ? (n.value.crmEnterpriseWarehousingId = a.value.crmEnterpriseWarehousingId, d.value = (p = (c = v.simpleFirmOptions) == null ? void 0 : c.filter((r) => r.id !== a.value.crmEnterpriseWarehousingId)) == null ? void 0 : p.map((r) => r.id)) : d.value = []);
  }
  function ue(i) {
    var e, u, c, p;
    n.value.crmEnterpriseWarehousingId && (n.value.boolProject || S({ id: i, type: m.SUPPLIER_INTO_RECORD_CONFIG.V }), o.value.crmProjectInformationWarehousingId && n.value.crmEnterpriseWarehousingId && n.value.crmProjectInformationWarehousingId === o.value.crmProjectInformationWarehousingId ? (o.value.crmEnterpriseWarehousingId = n.value.crmEnterpriseWarehousingId, d.value = (u = (e = v.simpleFirmOptions) == null ? void 0 : e.filter((r) => r.id !== n.value.crmEnterpriseWarehousingId)) == null ? void 0 : u.map((r) => r.id)) : a.value.crmProjectInformationWarehousingId && n.value.crmEnterpriseWarehousingId && n.value.crmProjectInformationWarehousingId === a.value.crmProjectInformationWarehousingId ? (a.value.crmEnterpriseWarehousingId = n.value.crmEnterpriseWarehousingId, d.value = (p = (c = v.simpleFirmOptions) == null ? void 0 : c.filter((r) => r.id !== n.value.crmEnterpriseWarehousingId)) == null ? void 0 : p.map((r) => r.id)) : d.value = []);
  }
  async function S({ id: i, type: e }) {
    try {
      await ke({ crmEnterpriseWarehousingId: i, crmPageManagementConfigEnum: e }) || (await je.confirm("当前选择企业已在该备案/平台中(备案/注册)请重新选择", "备案已绑定企业提醒", { closeOnClickModal: false, confirmButtonText: "为企业绑定项目", cancelButtonText: "重新选择企业", type: "warning" }), e === m.GOVERNMENT_RECORD_CONFIG.V && (o.value.boolProject = true, o.value.crmEnterpriseWarehousingId = void 0), e === m.SUPPLIER_INTO_RECORD_CONFIG.V && (n.value.boolProject = true, n.value.crmEnterpriseWarehousingId = void 0), e === m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V && (a.value.boolProject = true, a.value.crmEnterpriseWarehousingId = void 0));
    } catch (u) {
      e === m.GOVERNMENT_RECORD_CONFIG.V && (o.value.crmEnterpriseWarehousingId = void 0), e === m.SUPPLIER_INTO_RECORD_CONFIG.V && (n.value.crmEnterpriseWarehousingId = void 0), e === m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V && (a.value.crmEnterpriseWarehousingId = void 0), console.log(u);
    }
  }
  async function de() {
    const i = {};
    if (j.value) {
      if (!await C.value.validate()) return;
      W.value.includes(m.GOVERNMENT_RECORD_CONFIG.V) && (i.crmGovernmentWarehousingUpdateParam = o.value);
    } else i.crmGovernmentWarehousingUpdateParam = null;
    if (V.value) {
      if (!await T.value.validate()) return;
      W.value.includes(m.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.V) && (i.crmBiddingPlatformWarehousingUpdateParam = n.value);
    } else i.crmBiddingPlatformWarehousingUpdateParam = null;
    if (R.value) {
      if (!await _.value.validate()) return;
      W.value.includes(m.SUPPLIER_INTO_RECORD_CONFIG.V) && (i.crmSupplierWarehousingUpdateParam = a.value);
    } else i.crmSupplierWarehousingUpdateParam = null;
    try {
      G.value = true, await xe(i), Ve.success("下达成功"), K(), H("success");
    } catch (e) {
      console.log(e);
    } finally {
      G.value = false;
    }
  }
  async function me() {
    o.value.crmProjectInformationWarehousingId = void 0, await C.value.clearValidate(), await C.value.validate();
  }
  async function ce() {
    n.value.crmProjectInformationWarehousingId = void 0, await T.value.clearValidate(), await T.value.validate();
  }
  async function pe() {
    a.value.crmProjectInformationWarehousingId = void 0, await _.value.clearValidate(), await _.value.validate();
  }
  async function k() {
    await _.value.clearValidate(), await _.value.validate();
  }
  async function ge(i) {
    var e, u, c, p;
    if (o.value.crmEnterpriseWarehousingId = void 0, !!i) {
      try {
        const r = await B({ id: i });
        J.value = r || {}, E(r) && E(r == null ? void 0 : r.id) && (o.value.crmEnterpriseWarehousingId = r.id);
      } catch (r) {
        console.log(r, "获取政府备案绑定企业列表失败");
      }
      n.value.crmProjectInformationWarehousingId && n.value.crmEnterpriseWarehousingId && i === n.value.crmProjectInformationWarehousingId ? (o.value.crmEnterpriseWarehousingId = n.value.crmEnterpriseWarehousingId, d.value = (u = (e = v.simpleFirmOptions) == null ? void 0 : e.filter((r) => r.id !== n.value.crmEnterpriseWarehousingId)) == null ? void 0 : u.map((r) => r.id)) : a.value.crmProjectInformationWarehousingId && a.value.crmEnterpriseWarehousingId && a.value.crmProjectInformationWarehousingId === i ? (o.value.crmEnterpriseWarehousingId = a.value.crmEnterpriseWarehousingId, d.value = (p = (c = v.simpleFirmOptions) == null ? void 0 : c.filter((r) => r.id !== a.value.crmEnterpriseWarehousingId)) == null ? void 0 : p.map((r) => r.id)) : d.value = [];
    }
  }
  async function fe(i) {
    var e, u, c, p;
    if (n.value.crmEnterpriseWarehousingId = void 0, !!i) {
      try {
        const r = await B({ id: i });
        Q.value = r || {}, E(r) && E(r == null ? void 0 : r.id) && (n.value.crmEnterpriseWarehousingId = r.id);
      } catch (r) {
        console.log(r, "获取平台注册绑定企业列表失败");
      }
      o.value.crmProjectInformationWarehousingId && o.value.crmEnterpriseWarehousingId && i === o.value.crmProjectInformationWarehousingId ? (n.value.crmEnterpriseWarehousingId = o.value.crmEnterpriseWarehousingId, d.value = (u = (e = v.simpleFirmOptions) == null ? void 0 : e.filter((r) => r.id !== o.value.crmEnterpriseWarehousingId)) == null ? void 0 : u.map((r) => r.id)) : a.value.crmProjectInformationWarehousingId && a.value.crmEnterpriseWarehousingId && a.value.crmProjectInformationWarehousingId === i ? (n.value.crmEnterpriseWarehousingId = a.value.crmEnterpriseWarehousingId, d.value = (p = (c = v.simpleFirmOptions) == null ? void 0 : c.filter((r) => r.id !== a.value.crmEnterpriseWarehousingId)) == null ? void 0 : p.map((r) => r.id)) : d.value = [];
    }
  }
  async function ve(i) {
    var e, u, c, p;
    if (a.value.crmEnterpriseWarehousingId = void 0, !!i) {
      try {
        const r = await B({ id: i });
        X.value = r || {}, E(r) && E(r == null ? void 0 : r.id) && (a.value.crmEnterpriseWarehousingId = r.id);
      } catch (r) {
        console.log(r, "获取供应商备案绑定企业列表失败");
      }
      o.value.crmProjectInformationWarehousingId && o.value.crmEnterpriseWarehousingId && i === o.value.crmProjectInformationWarehousingId ? (a.value.crmEnterpriseWarehousingId = o.value.crmEnterpriseWarehousingId, d.value = (u = (e = v.simpleFirmOptions) == null ? void 0 : e.filter((r) => r.id !== o.value.crmEnterpriseWarehousingId)) == null ? void 0 : u.map((r) => r.id)) : n.value.crmProjectInformationWarehousingId && n.value.crmEnterpriseWarehousingId && n.value.crmProjectInformationWarehousingId === i ? (a.value.crmEnterpriseWarehousingId = n.value.crmEnterpriseWarehousingId, d.value = (p = (c = v.simpleFirmOptions) == null ? void 0 : c.filter((r) => r.id !== n.value.crmEnterpriseWarehousingId)) == null ? void 0 : p.map((r) => r.id)) : d.value = [];
    }
  }
  return (i, e) => {
    const u = Re, c = Oe, p = w("common-button"), r = w("common-radio"), g = ye, O = w("common-select"), x = Fe, D = Ne, Y = Ce, Ie = Te, he = we, Ee = w("common-drawer");
    return b(), y(Ee, { "before-close": P(K), "close-on-click-modal": false, visible: P($), size: "100%", title: "任务下达" }, { titleAfter: s(() => [t(c, { modelValue: W.value, "onUpdate:modelValue": e[0] || (e[0] = (I) => W.value = I), onChange: le }, { default: s(() => [(b(true), Pe(be, null, _e(ee.value, (I) => (b(), y(u, { key: I.K, label: I.V, value: I.V }, { default: s(() => [U(L(I.SL), 1)]), _: 2 }, 1032, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), titleRight: s(() => [t(p, { size: "default", type: "primary", onClick: de, disabled: !j.value && !V.value && !R.value, loading: G.value }, { default: s(() => e[16] || (e[16] = [U("确认")])), _: 1, __: [16] }, 8, ["disabled", "loading"])]), content: s(() => {
      var I;
      return [h("div", De, [j.value ? (b(), y(D, { key: 0, class: "card-box" }, { header: s(() => e[17] || (e[17] = [h("span", { style: { "font-weight": "bold" } }, "政府备案", -1)])), default: s(() => [t(x, { "label-width": "130px", "label-position": "right", rules: ae, ref_key: "assignmentGovernmentFormRef", ref: C, model: o.value }, { default: s(() => [h("div", Ue, [t(g, { label: "是否存在项目", class: "routine-item", prop: "boolProject" }, { default: s(() => [t(r, { modelValue: o.value.boolProject, "onUpdate:modelValue": e[1] || (e[1] = (l) => o.value.boolProject = l), options: M.value, type: "other", "data-structure": { key: "value", label: "name", value: "value" }, onChange: me }, null, 8, ["modelValue", "options"])]), _: 1 }), t(g, { label: "项目名称", class: "routine-item", prop: o.value.boolProject ? "crmProjectInformationWarehousingId" : "" }, { default: s(() => [t(O, { modelValue: o.value.crmProjectInformationWarehousingId, "onUpdate:modelValue": e[2] || (e[2] = (l) => o.value.crmProjectInformationWarehousingId = l), options: o.value.options, disabled: !o.value.boolProject, type: "other", placeholder: "选择项目名称", "data-structure": { key: "id", label: "projectName", value: "id" }, clearable: "", filterable: "", onChange: ge }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }, 8, ["prop"]), t(g, { label: "企业名称", class: "routine-item", prop: "crmEnterpriseWarehousingId" }, { default: s(() => {
        var l;
        return [t(O, { modelValue: o.value.crmEnterpriseWarehousingId, "onUpdate:modelValue": e[3] || (e[3] = (F) => o.value.crmEnterpriseWarehousingId = F), options: N.simpleFirmOptions, placeholder: "选择企业名称", disabled: P(E)((l = J.value) == null ? void 0 : l.id), disabledVal: d.value, onChange: te, clearable: "", filterable: "" }, null, 8, ["modelValue", "options", "disabled", "disabledVal"])];
      }), _: 1 }), t(g, { label: "备案规定", style: { width: "100%" }, prop: "attachmentIds" }, { default: s(() => [t(z, { ref: "uploadRef", files: o.value.attachmentIds, "onUpdate:files": e[4] || (e[4] = (l) => o.value.attachmentIds = l), showView: "", "show-download": "", "file-classify": P(q).RECORD_ATT.V, onSuccess: k }, null, 8, ["files", "file-classify"])]), _: 1 })])]), _: 1 }, 8, ["model"])]), _: 1 })) : A("", true), V.value ? (b(), y(D, { key: 1, class: "card-box" }, { header: s(() => e[18] || (e[18] = [h("span", { style: { "font-weight": "bold" } }, "平台注册", -1)])), default: s(() => [t(x, { "label-width": "130px", ref_key: "assignmentSignInFormRef", ref: T, "label-position": "right", rules: ne, model: n.value }, { default: s(() => [h("div", Le, [t(g, { label: "是否存在项目", class: "routine-item", prop: "boolProject" }, { default: s(() => [t(r, { modelValue: n.value.boolProject, "onUpdate:modelValue": e[5] || (e[5] = (l) => n.value.boolProject = l), options: M.value, type: "other", "data-structure": { key: "value", label: "name", value: "value" }, onChange: ce }, null, 8, ["modelValue", "options"])]), _: 1 }), t(g, { label: "项目名称", class: "routine-item", prop: n.value.boolProject ? "crmProjectInformationWarehousingId" : "" }, { default: s(() => [t(O, { modelValue: n.value.crmProjectInformationWarehousingId, "onUpdate:modelValue": e[6] || (e[6] = (l) => n.value.crmProjectInformationWarehousingId = l), options: n.value.options, type: "other", placeholder: "选择项目名称", disabled: !n.value.boolProject, "data-structure": { key: "id", label: "projectName", value: "id" }, clearable: "", filterable: "", onChange: fe }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }, 8, ["prop"]), t(g, { label: "企业名称", class: "routine-item", prop: "crmEnterpriseWarehousingId" }, { default: s(() => {
        var l;
        return [t(O, { modelValue: n.value.crmEnterpriseWarehousingId, "onUpdate:modelValue": e[7] || (e[7] = (F) => n.value.crmEnterpriseWarehousingId = F), options: N.simpleFirmOptions, placeholder: "选择企业名称", clearable: "", filterable: "", disabled: P(E)((l = Q.value) == null ? void 0 : l.id), disabledVal: d.value, onChange: ue }, null, 8, ["modelValue", "options", "disabled", "disabledVal"])];
      }), _: 1 }), t(g, { label: "招标平台名称", class: "routine-item", prop: "biddingPlatformName" }, { default: s(() => [t(Y, { modelValue: n.value.biddingPlatformName, "onUpdate:modelValue": e[8] || (e[8] = (l) => n.value.biddingPlatformName = l), placeholder: "填写招标平台名称", maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), t(g, { label: "报名事由", class: "routine-item", prop: "reasonForRegistration" }, { default: s(() => [t(Y, { modelValue: n.value.reasonForRegistration, "onUpdate:modelValue": e[9] || (e[9] = (l) => n.value.reasonForRegistration = l), placeholder: "填写报名事由", maxlength: "30" }, null, 8, ["modelValue"])]), _: 1 }), t(g, { label: "入库通知文件", style: { width: "100%" }, prop: "attachmentIds" }, { default: s(() => [t(z, { files: n.value.attachmentIds, "onUpdate:files": e[10] || (e[10] = (l) => n.value.attachmentIds = l), showView: "", "show-download": "", "file-classify": P(q).RECORD_ATT.V, onSuccess: k }, null, 8, ["files", "file-classify"])]), _: 1 })])]), _: 1 }, 8, ["model"])]), _: 1 })) : A("", true), R.value ? (b(), y(D, { key: 2, class: "card-box" }, { header: s(() => e[19] || (e[19] = [h("span", { style: { "font-weight": "bold" } }, "供应商备案", -1)])), default: s(() => [t(x, { "label-width": "130px", "label-position": "right", ref_key: "assignmentSupplierFormRef", ref: _, rules: oe, model: a.value }, { default: s(() => [h("div", qe, [t(g, { label: "是否存在项目", class: "routine-item", prop: "boolProject" }, { default: s(() => [t(r, { modelValue: a.value.boolProject, "onUpdate:modelValue": e[11] || (e[11] = (l) => a.value.boolProject = l), options: M.value, type: "other", "data-structure": { key: "value", label: "name", value: "value" }, onChange: pe }, null, 8, ["modelValue", "options"])]), _: 1 }), t(g, { label: "项目名称", class: "routine-item", prop: a.value.boolProject ? "crmProjectInformationWarehousingId" : "" }, { default: s(() => [t(O, { modelValue: a.value.crmProjectInformationWarehousingId, "onUpdate:modelValue": e[12] || (e[12] = (l) => a.value.crmProjectInformationWarehousingId = l), options: a.value.options, disabled: !a.value.boolProject, type: "other", placeholder: "选择项目名称", "data-structure": { key: "id", label: "projectName", value: "id" }, clearable: "", filterable: "", onChange: ve }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }, 8, ["prop"]), t(g, { label: "企业名称", class: "routine-item", prop: "crmEnterpriseWarehousingId" }, { default: s(() => {
        var l;
        return [t(O, { modelValue: a.value.crmEnterpriseWarehousingId, "onUpdate:modelValue": e[13] || (e[13] = (F) => a.value.crmEnterpriseWarehousingId = F), options: N.simpleFirmOptions, placeholder: "选择企业名称", clearable: "", filterable: "", disabled: P(E)((l = X.value) == null ? void 0 : l.id), disabledVal: d.value, onChange: se }, null, 8, ["modelValue", "options", "disabled", "disabledVal"])];
      }), _: 1 }), t(g, { label: "企业联系方式", class: "routine-item" }, { default: s(() => {
        var l;
        return [h("span", null, L(((l = v.simpleFirmMap[a.value.crmEnterpriseWarehousingId]) == null ? void 0 : l.businessPhone) || "-"), 1)];
      }), _: 1 }), t(g, { label: "企业邮箱", class: "routine-item" }, { default: s(() => {
        var l;
        return [h("span", null, L(((l = v.simpleFirmMap[a.value.crmEnterpriseWarehousingId]) == null ? void 0 : l.businessEmail) || "-"), 1)];
      }), _: 1 }), t(g, { label: "受理截止日", class: "routine-item", prop: "deadlineForAcceptanceTime" }, { default: s(() => [t(Ie, { modelValue: a.value.deadlineForAcceptanceTime, "onUpdate:modelValue": e[14] || (e[14] = (l) => a.value.deadlineForAcceptanceTime = l), placeholder: "选择受理截止日", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), t(g, { label: "入库通知文件", style: { width: "100%" }, prop: "attachmentIds" }, { default: s(() => [t(z, { files: a.value.attachmentIds, "onUpdate:files": e[15] || (e[15] = (l) => a.value.attachmentIds = l), showView: "", "show-download": "", "file-classify": P(q).RECORD_ATT.V, onSuccess: k }, null, 8, ["files", "file-classify"])]), _: 1 })])]), _: 1 }, 8, ["model"])]), _: 1 })) : A("", true)]), ((I = W.value) == null ? void 0 : I.length) === 0 ? (b(), y(he, { key: 0, type: "danger", size: "large" }, { default: s(() => e[20] || (e[20] = [U("* 请先选择需要下达的备案")])), _: 1, __: [20] })) : A("", true)];
    }), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Xe = Ae(Be, [["__scopeId", "data-v-e8cecd14"]]);
export {
  Xe as default
};
