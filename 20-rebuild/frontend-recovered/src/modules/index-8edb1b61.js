import { useStore as U } from "vuex";
import { ref as d } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as m } from "vue";
import { createBlock as A } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as r } from "vue";
import { createTextVNode as k } from "vue";
import { ElNotification as F } from "element-plus";
import { ElInput as L } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElForm as P } from "element-plus";
import { watch as E } from "vue";
import { resolveDirective as N } from "vue";
import { createElementBlock as V } from "vue";
import { toDisplayString as q } from "vue";
import { withDirectives as T } from "vue";
import { unref as H } from "vue";
import { createCommentVNode as O } from "vue";
import { withModifiers as $ } from "vue";
import { normalizeClass as G } from "vue";
import { Plus as K } from "@element-plus/icons-vue";
import { ElIcon as W } from "element-plus";
import { ElPopover as J } from "element-plus";
import { bH as z, lk as Q, bF as x, tT as X, iW as Y, _ as Z, b as I, ai as ee } from "../shared/runtime.js";
const le = { style: { "text-align": "right" } }, ae = { __name: "add-supplier", emits: ["close"], setup(S, { emit: h }) {
  const f = h, a = U(), b = d(), n = d(false), c = { name: "", socialCode: "", supplierClass: z.LOGISTICS.V, supplierClassification: z.LOGISTICS.V }, s = d({ ...c }), g = { name: [{ required: true, message: "请输入供应商名称", trigger: "blur" }, { min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], supplierClass: [{ required: true, message: "请选择供应商分类", trigger: "blur" }] };
  function w() {
    s.value = { ...c };
  }
  async function B() {
    const C = await b.value.validate();
    try {
      C && (n.value = true, await Q([{ ...s.value }]), y(), w(), F({ title: "新增成功", type: "success" }), a.dispatch("config/fetchSuppliers"));
    } catch (l) {
      console.log("新增供应商", l);
    } finally {
      n.value = false;
    }
  }
  function y() {
    f("close");
  }
  return (C, l) => {
    const e = L, t = M, u = j("common-button"), _ = P;
    return m(), A(_, { ref_key: "formRef", ref: b, model: s.value, rules: g, size: "default", "label-width": "100px" }, { default: i(() => [o(t, { label: "物流单位", prop: "name" }, { default: i(() => [o(e, { modelValue: s.value.name, "onUpdate:modelValue": l[0] || (l[0] = (v) => s.value.name = v), maxlength: "32", "show-word-limit": "", placeholder: "请输入供应商名称" }, null, 8, ["modelValue"])]), _: 1 }), o(t, { label: "社会统一代码", prop: "socialCode" }, { default: i(() => [o(e, { modelValue: s.value.socialCode, "onUpdate:modelValue": l[1] || (l[1] = (v) => s.value.socialCode = v), placeholder: "请输入社会统一代码", maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), r("div", le, [o(u, { loading: n.value, type: "primary", size: "default", onClick: B }, { default: i(() => l[2] || (l[2] = [k("提 交")])), _: 1, __: [2] }, 8, ["loading"]), o(u, { size: "default", onClick: y }, { default: i(() => l[3] || (l[3] = [k("关闭")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"]);
  };
} };
const te = { style: { "overflow-x": "auto", width: "100%" } }, se = { class: "customize-option-item" }, oe = { class: "flex-rsc label" }, ne = { key: 0, class: "extra-label" }, ie = { key: 1 }, ue = { __name: "index", props: { modelValue: { type: [Number, String, Array] }, basicClass: { type: Number }, logisticsCreateable: { type: Boolean, default: false }, showType: { type: Boolean, default: false }, type: { type: Number, default: x.RAW_MATERIAL.V | x.MANUFACTURED.V | x.OTHER.V }, mode: { type: String, default: "contained" }, typeMode: { type: String, default: "cross" }, showHide: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择供应商" }, isAnnual: { type: Boolean, default: false }, projectId: { type: Number, default: void 0 } }, emits: ["change", "info-change", "update:modelValue"], setup(S, { emit: h }) {
  const f = h, a = S, b = { add: ["scm_supplier:add"] }, n = d(false), c = d(), s = d([]), g = d({});
  E(() => a.modelValue, (l) => {
    c.value = l;
  }, { immediate: true }), E(() => a.projectId, (l) => {
    w();
  }, { immediate: true });
  async function w() {
    var l;
    try {
      const e = await X({ projectId: a.projectId });
      s.value = e || [], (l = s.value) == null || l.forEach((t) => {
        g.value[t.id] = t;
      });
    } catch (e) {
      console.log(e, "获取当前项目下的供应商列表失败");
    }
  }
  function B(l) {
    let e = l;
    I(e) && (e = void 0);
    const t = !ee(e, a.modelValue), u = I(e) && I(a.modelValue);
    t && !u && (f("update:modelValue", e), f("change", e), y(e, a.modelValue));
  }
  function y(l, e) {
    const t = g.value, u = l ? t[l] : null, _ = e ? t[e] : null;
    f("info-change", u, _);
  }
  function C() {
    n.value = false;
  }
  return (l, e) => {
    const t = j("common-select-v2"), u = K, _ = W, v = J, R = N("parse-enum"), D = N("permission");
    return m(), V("span", { class: G([{ "show-add-icon": a.logisticsCreateable }, "supplier-sn-select-container"]) }, [o(t, { modelValue: c.value, "onUpdate:modelValue": e[0] || (e[0] = (p) => c.value = p), clearable: a.clearable, "collapse-tags": a.collapseTags, disabled: a.disabled, filterable: a.filterable, multiple: a.multiple, options: s.value, placeholder: a.placeholder, size: a.size, "data-structure": { key: "supplierId", label: "supplierName", value: "supplierId" }, class: "supplier-sn-select", onChange: B }, { view: i(({ data: p }) => [r("div", te, [r("span", se, [r("span", oe, [r("span", null, q(p.supplierName), 1)]), r("span", null, [a.showType ? (m(), V("span", ne, [e[3] || (e[3] = r("span", { class: "title" }, "类型：", -1)), T(r("span", null, null, 512), [[R, { e: H(Y), v: p.basicClass, bit: true, split: " | " }]])])) : O("", true)])])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "filterable", "multiple", "options", "placeholder", "size"]), o(v, { visible: n.value, "onUpdate:visible": e[2] || (e[2] = (p) => n.value = p), placement: "top", width: "450" }, { reference: i(() => [a.logisticsCreateable ? (m(), V("span", { key: 0, class: "add-icon pointer", onClick: e[1] || (e[1] = $((p) => n.value = !n.value, ["stop"])) }, [T((m(), A(_, { color: "#1881ef" }, { default: i(() => [o(u)]), _: 1 })), [[D, b.add]])])) : (m(), V("span", ie))]), default: i(() => [o(ae, { onClose: C })]), _: 1 }, 8, ["visible"])], 2);
  };
} }, de = Z(ue, [["__scopeId", "data-v-465f1f02"]]);
export {
  de as s
};
