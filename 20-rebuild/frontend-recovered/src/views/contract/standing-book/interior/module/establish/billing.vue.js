import { ref as _ } from "vue";
import { useStore as W } from "vuex";
import { computed as A } from "vue";
import { watchEffect as X } from "vue";
import { nextTick as Y } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as l } from "vue";
import { withCtx as a } from "vue";
import { createBlock as I } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as Z } from "vue";
import { unref as n } from "vue";
import { createElementVNode as d } from "vue";
import { Fragment as B } from "vue";
import { renderList as N } from "vue";
import { ElTag as h } from "element-plus";
import { ElButton as ee } from "element-plus";
import { ElCol as le } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { ElFormItem as te } from "element-plus";
import { ElRow as oe } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElOption as se } from "element-plus";
import { ElSelect as ie } from "element-plus";
import { ElForm as ue } from "element-plus";
import { ElDivider as pe } from "element-plus";
import { ElDrawer as de } from "element-plus";
import { _ as re, ao as ce, ia as me, bD as fe, dp as _e, fv as ve, cy as be, R as ye, b as Ve, kS as ge, ec as we, iV as Ie, dq as Te, kT as xe, e2 as Ue, e6 as F } from "../../../../../../shared/runtime.js";
import { b as je } from "../../../../../../modules/data-039b7fd9.js";
const Re = { class: "collection-container" }, ke = { __name: "billing", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(C, { emit: L }) {
  const S = C, v = _(je), x = W(), U = { attachmentId: [], writtenById: x.getters.user.id, invoiceDate: (/* @__PURE__ */ new Date()).getTime() };
  function M() {
    U.invoiceDate = (/* @__PURE__ */ new Date()).getTime();
  }
  const { crud: b, form: t } = ce(U), j = A(() => t != null && t.invoiceAmount ? me(t.invoiceAmount) : ""), y = _(null), O = Object.values(fe.V), R = _([]), V = _(false), P = async () => {
    if (!Ve(t.projectId)) try {
      const i = await ge({ projectId: t.projectId }), e = we([i])[0], { projectAttribute: m, projectManagerName: f, collectionAmountSum: s, userId: g, invoiceUnit: p, projectName: u, collectionUnit: r } = e;
      Object.assign(t, { projectAttribute: m, projectManagerName: f, collectionAmountSum: s, writtenById: g, invoiceUnit: p, projectName: u, collectionUnit: r }), await q();
    } catch {
    }
  }, q = async () => {
    try {
      const { content: i } = await Ie();
      R.value = i;
    } catch (i) {
      console.log(i);
    }
  }, z = async () => {
    t.invoiceType === 4 ? (t.taxRateTypeValue = null, v.value.taxRateTypeValue = []) : v.value.taxRateTypeValue = [{ required: true, message: "发票税率不能为空", trigger: ["blur", "change"] }], y.value.validate().then(async () => {
      var i;
      try {
        V.value = true;
        const e = Te(t);
        (i = e == null ? void 0 : e.attachment) != null && i.length && (e.attachmentId = e.attachment.map((m) => m.id)), await xe(e), Ue("success", "填报成功"), F(t, { sustainable: ["invoiceDate"] }), await b.toQuery(), await b.crudApi.getAmount(), await x.dispatch("approval_list/fetchApprovalNum"), k();
      } catch (e) {
        console.log(e);
      } finally {
        V.value = false;
      }
    });
  }, Q = L, k = () => {
    t != null && t.attachment && (t.attachment = []), F(t, { sustainable: ["invoiceDate"] }), Q("update:visible", false);
  };
  X(() => {
    t.invoiceType === 4 && (t.taxRateTypeValue = null, Y(() => {
      y.value.clearValidate("taxRateTypeValue");
    }));
  });
  const H = (i) => {
    i.length > 1 && (t.attachment = [i[i.length - 1]]);
  }, K = A(() => !(t != null && t.projectId));
  return (i, e) => {
    const m = h, f = ee, s = le, g = ae, p = te, u = oe, r = ne, E = se, D = ie, $ = ue, G = pe, J = de;
    return c(), w("div", Re, [l(J, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": S.visible, "show-close": false, "destroy-on-close": "", size: "40%", onOpend: M }, { header: a(() => [l(_e, { "type-one": false, "header-title": "开票填报" }, { subTitle: a(() => [K.value ? (c(), I(m, { key: 0, size: "default", type: "danger" }, { default: a(() => e[11] || (e[11] = [T("请先进行项目选择!")])), _: 1, __: [11] })) : Z("", true)]), _: 1 }), l(f, { plain: "", onClick: k }, { default: a(() => e[12] || (e[12] = [T("关闭")])), _: 1, __: [12] }), l(f, { loading: V.value, type: "success", onClick: z }, { default: a(() => e[13] || (e[13] = [T("创建")])), _: 1, __: [13] }, 8, ["loading"])]), default: a(() => [l($, { ref_key: "formRef", ref: y, model: n(t), rules: v.value, class: "form-container", "label-position": "left" }, { default: a(() => [l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[14] || (e[14] = [d("span", { class: "prop-span label" }, "开票日期：", -1)])), _: 1, __: [14] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "invoiceDate" }, { default: a(() => [l(g, { modelValue: n(t).invoiceDate, "onUpdate:modelValue": e[0] || (e[0] = (o) => n(t).invoiceDate = o), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[15] || (e[15] = [d("span", { class: "prop-span label" }, "项目：", -1)])), _: 1, __: [15] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "projectId" }, { default: a(() => [l(ve, { modelValue: n(t).projectId, "onUpdate:modelValue": e[1] || (e[1] = (o) => n(t).projectId = o), projectManagerId: n(b).query.projectManagerId, class: "filter-item", clearable: "", onChange: P }, null, 8, ["modelValue", "projectManagerId"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[16] || (e[16] = [d("span", { class: "prop-span label" }, "本次开票：", -1)])), _: 1, __: [16] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "invoiceAmount" }, { default: a(() => [l(r, { modelValue: n(t).invoiceAmount, "onUpdate:modelValue": e[2] || (e[2] = (o) => n(t).invoiceAmount = o), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[17] || (e[17] = [d("span", { class: "label" }, "大写：", -1)])), _: 1, __: [17] }), l(s, { span: 20 }, { default: a(() => [l(r, { modelValue: j.value, "onUpdate:modelValue": e[3] || (e[3] = (o) => j.value = o), placeholder: "输入本次开票", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[18] || (e[18] = [d("span", { class: "prop-span label" }, "发票类型：", -1)])), _: 1, __: [18] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "invoiceType" }, { default: a(() => [l(D, { modelValue: n(t).invoiceType, "onUpdate:modelValue": e[4] || (e[4] = (o) => n(t).invoiceType = o), clearable: "", placeholder: "请选择发票类型" }, { default: a(() => [(c(true), w(B, null, N(n(O), (o) => (c(), I(E, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[19] || (e[19] = [d("span", { class: "prop-span label" }, "税率：", -1)])), _: 1, __: [19] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "taxRateTypeValue" }, { default: a(() => [l(D, { modelValue: n(t).taxRateTypeValue, "onUpdate:modelValue": e[5] || (e[5] = (o) => n(t).taxRateTypeValue = o), disabled: n(t).invoiceType === 4 }, { default: a(() => [(c(true), w(B, null, N(R.value, (o) => (c(), I(E, { key: o.id, label: o.label + "%", value: o.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[20] || (e[20] = [d("span", { class: "prop-span label" }, "开票单位：", -1)])), _: 1, __: [20] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "invoiceUnit" }, { default: a(() => [l(r, { modelValue: n(t).invoiceUnit, "onUpdate:modelValue": e[6] || (e[6] = (o) => n(t).invoiceUnit = o), clearable: "", placeholder: "请输入开票单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[21] || (e[21] = [d("span", { class: "prop-span label" }, "收票单位：", -1)])), _: 1, __: [21] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "collectionUnit" }, { default: a(() => [l(r, { modelValue: n(t).collectionUnit, "onUpdate:modelValue": e[7] || (e[7] = (o) => n(t).collectionUnit = o), clearable: "", placeholder: "请输入收票单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[22] || (e[22] = [d("span", { class: "prop-span label" }, "发票号码：", -1)])), _: 1, __: [22] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "invoiceNo" }, { default: a(() => [l(r, { modelValue: n(t).invoiceNo, "onUpdate:modelValue": e[8] || (e[8] = (o) => n(t).invoiceNo = o), clearable: "", placeholder: "请输入发票号码" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(u, null, { default: a(() => [l(s, { span: 4 }, { default: a(() => e[23] || (e[23] = [d("span", { class: "prop-span label" }, "创建人：", -1)])), _: 1, __: [23] }), l(s, { span: 20 }, { default: a(() => [l(p, { prop: "writtenById" }, { default: a(() => [l(be, { modelValue: n(t).writtenById, "onUpdate:modelValue": e[9] || (e[9] = (o) => n(t).writtenById = o), "collapse-tags": false, class: "input-underline", clearable: "", filterable: "", placeholder: "请选择或输入创建人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), l(G, null, { default: a(() => e[24] || (e[24] = [d("span", { class: "title" }, "附件", -1)])), _: 1, __: [24] }), l(ye, { files: n(t).attachment, "onUpdate:files": [e[10] || (e[10] = (o) => n(t).attachment = o), H], limit: 1, multiple: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, Be = re(ke, [["__scopeId", "data-v-17c40b52"]]);
export {
  Be as default
};
