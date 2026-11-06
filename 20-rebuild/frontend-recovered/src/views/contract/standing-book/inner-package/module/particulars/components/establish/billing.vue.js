import { ref as g } from "vue";
import { reactive as W } from "vue";
import { computed as X } from "vue";
import { inject as D } from "vue";
import { watch as A } from "vue";
import { watchEffect as Y } from "vue";
import { nextTick as Z } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as r } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as R } from "vue";
import { unref as U } from "vue";
import { createCommentVNode as ee } from "vue";
import { Fragment as N } from "vue";
import { renderList as L } from "vue";
import { createElementVNode as le } from "vue";
import { ElButton as ae } from "element-plus";
import { ElCol as te } from "element-plus";
import { ElDatePicker as oe } from "element-plus";
import { ElFormItem as ne } from "element-plus";
import { ElRow as se } from "element-plus";
import { ElSelect as ie } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElOption as pe } from "element-plus";
import { ElCascader as ue } from "element-plus";
import { ElForm as re } from "element-plus";
import { ElDivider as ce } from "element-plus";
import { ElDrawer as me } from "element-plus";
import { _ as fe, ia as _e, bD as ve, e6 as C, dp as be, R as ge, kS as Ve, ec as ye, iV as we, dq as xe, kT as je, e2 as Re } from "../../../../../../../../shared/runtime.js";
import { b as Ue } from "../../../../../../../../modules/data-039b7fd9.js";
const Ie = { class: "collection-container" }, Ee = { class: "prop-span label" }, ke = { class: "prop-span label" }, Be = { class: "label" }, Te = { class: "prop-span label" }, De = { class: "label" }, Ae = { class: "prop-span label" }, Ne = { class: "prop-span label" }, Le = { class: "prop-span label" }, Ce = { class: "prop-span label" }, Fe = { class: "prop-span label" }, Pe = { class: "prop-span label" }, Se = { __name: "billing", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(F, { emit: P }) {
  const I = F, V = g(Ue), t = W({ attachmentId: [], invoiceDate: (/* @__PURE__ */ new Date()).getTime() }), E = X(() => t != null && t.invoiceAmount ? _e(t.invoiceAmount) : ""), { projectInfo: y } = D("info_parent_data"), { _commonFn: v, projectLeaderList: S } = D("parent_data"), w = g(null), q = Object.values(ve.V), k = g([]), x = g(false), M = async () => {
    try {
      const s = await Ve({ projectId: t.projectId }), l = ye([s])[0], { projectAttribute: p, projectManagerName: n, collectionAmountSum: j, userId: c, invoiceUnit: u, projectName: b, collectionUnit: _ } = l;
      Object.assign(t, { projectAttribute: p, projectManagerName: n, collectionAmountSum: j, writtenById: c, invoiceUnit: u, projectName: b, collectionUnit: _ }), await O();
    } catch {
    }
  }, O = async () => {
    try {
      const { content: s } = await we();
      k.value = s;
    } catch (s) {
      console.log(s);
    }
  }, z = async () => {
    t.invoiceType === 4 ? (t.taxRate = null, V.value.taxRate = []) : V.value.taxRate = [{ required: true, message: "发票税率不能为空", trigger: ["blur", "change"] }], w.value.validate().then(async () => {
      var s, l;
      try {
        x.value = true;
        const p = xe(t);
        (s = p == null ? void 0 : p.attachment) != null && s.length && (p.attachmentId = p.attachment.map((n) => n.id)), await je(p), Re("success", "填报成功"), await v.value.getProjectSum(), await v.value.getExpendIdDetail(), (l = v == null ? void 0 : v.value) != null && l.getBillingRecordList && await v.value.getBillingRecordList(), C(t, { sustainable: ["invoiceDate"] }), B();
      } catch (p) {
        console.log(p);
      } finally {
        x.value = false;
      }
    });
  }, h = P, B = () => {
    t != null && t.attachment && (t.attachment = []), h("update:visible", false);
  };
  A(() => I.visible, async (s) => {
    s && (t.projectId = y.project.id, await M());
  }, { immediate: true }), Y(() => {
    t.invoiceType === 4 && (t.taxRate = null, Z(() => {
      w.value.clearValidate("taxRate");
    }));
  }), A(() => {
    var s;
    return (s = y.project) == null ? void 0 : s.id;
  }, (s, l) => {
    s !== l && C(t, { sustainable: ["invoiceDate"] });
  });
  const H = (s) => {
    s.length > 1 && (t.attachment = [s[s.length - 1]]);
  };
  return (s, l) => {
    const p = ae, n = te, j = oe, c = ne, u = se, b = ie, _ = de, T = pe, K = ue, Q = re, G = ce, J = me, m = $("ellipsis");
    return i(), d("div", Ie, [e(J, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": I.visible, "show-close": false, "destroy-on-close": "", size: "40%" }, { header: a(() => [e(be, { "type-one": false, "header-title": "开票填报" }), e(p, { plain: "", onClick: B }, { default: a(() => l[11] || (l[11] = [r("关闭")])), _: 1, __: [11] }), e(p, { loading: x.value, type: "success", onClick: z }, { default: a(() => l[12] || (l[12] = [r("创建")])), _: 1, __: [12] }, 8, ["loading"])]), default: a(() => [e(Q, { ref_key: "formRef", ref: w, model: t, rules: V.value, class: "form-container", "label-position": "left" }, { default: a(() => [e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Ee, l[13] || (l[13] = [r("开票日期：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "invoiceDate" }, { default: a(() => [e(j, { modelValue: t.invoiceDate, "onUpdate:modelValue": l[0] || (l[0] = (o) => t.invoiceDate = o), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", ke, l[14] || (l[14] = [r("项目：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "date" }, { default: a(() => [e(b, { modelValue: t.projectName, "onUpdate:modelValue": l[1] || (l[1] = (o) => t.projectName = o), clearable: "", disabled: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), t.projectAttribute === 3 ? (i(), R(u, { key: 0 }, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Be, l[15] || (l[15] = [r("项目经理：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(_, { "model-value": U(y).projectManagerName || "无", disabled: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })) : ee("", true), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Te, l[16] || (l[16] = [r("本次开票：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "invoiceAmount" }, { default: a(() => [e(_, { modelValue: t.invoiceAmount, "onUpdate:modelValue": l[2] || (l[2] = (o) => t.invoiceAmount = o), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", De, l[17] || (l[17] = [r("大写：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(_, { modelValue: E.value, "onUpdate:modelValue": l[3] || (l[3] = (o) => E.value = o), placeholder: "输入本次开票", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Ae, l[18] || (l[18] = [r("发票类型：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "invoiceType" }, { default: a(() => [e(b, { modelValue: t.invoiceType, "onUpdate:modelValue": l[4] || (l[4] = (o) => t.invoiceType = o), clearable: "", placeholder: "请选择发票类型" }, { default: a(() => [(i(true), d(N, null, L(U(q), (o) => (i(), R(T, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Ne, l[19] || (l[19] = [r("税率：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "taxRate" }, { default: a(() => [e(b, { modelValue: t.taxRate, "onUpdate:modelValue": l[5] || (l[5] = (o) => t.taxRate = o), disabled: t.invoiceType === 4 }, { default: a(() => [(i(true), d(N, null, L(k.value, (o) => (i(), R(T, { key: o.id, label: o.label + "%", value: o.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Le, l[20] || (l[20] = [r("开票单位：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "invoiceUnit" }, { default: a(() => [e(_, { modelValue: t.invoiceUnit, "onUpdate:modelValue": l[6] || (l[6] = (o) => t.invoiceUnit = o), clearable: "", placeholder: "请输入开票单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Ce, l[21] || (l[21] = [r("收票单位：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "collectionUnit" }, { default: a(() => [e(_, { modelValue: t.collectionUnit, "onUpdate:modelValue": l[7] || (l[7] = (o) => t.collectionUnit = o), clearable: "", placeholder: "请输入收票单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Fe, l[22] || (l[22] = [r("发票号码：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "invoiceNo" }, { default: a(() => [e(_, { modelValue: t.invoiceNo, "onUpdate:modelValue": l[8] || (l[8] = (o) => t.invoiceNo = o), clearable: "", placeholder: "请输入发票号码" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(u, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => [f((i(), d("span", Pe, l[23] || (l[23] = [r("创建人：")]))), [[m]])]), _: 1 }), e(n, { span: 20 }, { default: a(() => [e(c, { prop: "writtenById" }, { default: a(() => [e(K, { modelValue: t.writtenById, "onUpdate:modelValue": l[9] || (l[9] = (o) => t.writtenById = o), options: U(S), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "请选择或输入创建人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), e(G, null, { default: a(() => l[24] || (l[24] = [le("span", { class: "title" }, "附件", -1)])), _: 1, __: [24] }), e(ge, { files: t.attachment, "onUpdate:files": [l[10] || (l[10] = (o) => t.attachment = o), H], limit: 1, multiple: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, ze = fe(Se, [["__scopeId", "data-v-bbc4ab09"]]);
export {
  ze as default
};
