import { ref as u } from "vue";
import { ElMessage as x } from "element-plus";
import { resolveComponent as p } from "vue";
import { openBlock as z } from "vue";
import { createBlock as F } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { unref as s } from "vue";
import { createTextVNode as h } from "vue";
import { createElementVNode as M } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElInputNumber as I } from "element-plus";
import { ElForm as K } from "element-plus";
import { _ as S, ao as $, o as q, fK as v } from "../../../../../../../shared/runtime.js";
const T = { class: "add-row-box" }, D = { __name: "form", setup(A) {
  const _ = u(), w = u(), g = u(), k = { list: [] }, { CRUD: b, crud: m, form: c } = $(k, _), { maxHeight: C } = q({ mainBox: ".config-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, extraHeight: 80, minHeight: 300 }, () => g.value.loaded), y = { name: [{ required: true, message: "请输入付款属性", trigger: "blur" }], sort: [{ required: true, message: "请输入排序", trigger: "blur" }] };
  function R({ row: e, column: t }) {
    if (!e) return;
    const r = y;
    let l = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (l = v(t.property, r[t.property], e)), l && (e.verify[t.property] = true)), l ? "" : "mask-td";
  }
  function V(e) {
    c.list.splice(e, 1);
  }
  function H() {
    c.list.push({ name: void 0 });
  }
  b.HOOK.beforeValidateCU = (e, t) => {
    if (e.form.list.length <= 0) return x({ message: "请先填写付款属性明细", type: "error" }), false;
    const r = y;
    let l = true;
    if (e.form.list.map((i) => {
      i.verify = {};
      for (const d in r) i.verify[d] = v(d, r[d], i), i.verify[d] || (l = false);
    }), !l) return x.error("请填写表格中标红数据"), false;
  };
  async function U() {
  }
  return b.HOOK.afterSubmit = () => {
    U();
  }, (e, t) => {
    const r = p("common-button"), l = N, i = j, d = I, B = p("common-table"), E = K, O = p("common-drawer");
    return z(), F(O, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(m).cancelCU, visible: s(m).status.cu > 0, title: s(m).status.title, "wrapper-closable": false, "custom-class": "config-detail", ref_key: "drawerRef", ref: g, size: "860px" }, { titleRight: a(() => [o(r, { loading: s(m).status.cu === 2, type: "primary", size: "default", onClick: s(m).submitCU }, { default: a(() => t[1] || (t[1] = [h("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: a(() => [o(E, { ref_key: "formRef", ref: _, model: s(c), size: "default", "label-width": "140px" }, { default: a(() => [o(B, { ref_key: "detailRef", ref: w, border: "", data: s(c).list, "max-height": s(C), style: { width: "100%" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": R }, { default: a(() => [o(l, { label: "序号", type: "index", align: "center", width: "55" }), o(l, { prop: "name", label: "付款属性", align: "center", "min-width": "270" }, { default: a((n) => [o(i, { modelValue: n.row.name, "onUpdate:modelValue": (f) => n.row.name = f, type: "text", placeholder: "付款属性", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(l, { prop: "name", label: "排序", align: "center", "min-width": "150" }, { default: a((n) => [o(d, { modelValue: n.row.sort, "onUpdate:modelValue": (f) => n.row.sort = f, modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(l, { label: "操作", align: "center" }, { default: a((n) => [o(r, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (f) => V(n.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), M("div", T, [o(r, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: t[0] || (t[0] = (n) => H()) }, { default: a(() => t[2] || (t[2] = [h("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, L = S(D, [["__scopeId", "data-v-93c36034"]]);
export {
  L as default
};
