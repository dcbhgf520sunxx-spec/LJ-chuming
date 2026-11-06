import { ref as b } from "vue";
import { ElMessage as g } from "element-plus";
import { resolveComponent as m } from "vue";
import { openBlock as z } from "vue";
import { createBlock as E } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { unref as s } from "vue";
import { createTextVNode as v } from "vue";
import { createElementVNode as F } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElForm as K } from "element-plus";
import { _ as N, ao as S, fK as x } from "../../../../../../../shared/runtime.js";
const $ = { class: "add-row-box" }, H = { __name: "form", setup(I) {
  const u = b(), k = b(), h = { list: [] }, { CRUD: p, crud: f, form: d } = S(h, u), _ = { name: [{ required: true, message: "请输入签证原因", trigger: "blur" }] };
  function C({ row: e, column: t }) {
    if (!e) return;
    const a = _;
    let l = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (l = x(t.property, a[t.property], e)), l && (e.verify[t.property] = true)), l ? "" : "mask-td";
  }
  function R(e) {
    d.list.splice(e, 1);
  }
  function w() {
    d.list.push({ name: void 0 });
  }
  p.HOOK.beforeValidateCU = (e, t) => {
    if (e.form.list.length <= 0) return g({ message: "请先填写签证原因明细", type: "error" }), false;
    const a = _;
    let l = true;
    if (e.form.list.map((r) => {
      r.verify = {};
      for (const i in a) r.verify[i] = x(i, a[i], r), r.verify[i] || (l = false);
    }), !l) return g.error("请填写表格中标红数据"), false;
  };
  async function V() {
  }
  return p.HOOK.afterSubmit = () => {
    V();
  }, (e, t) => {
    const a = m("common-button"), l = B, r = j, i = m("common-table"), O = K, U = m("common-drawer");
    return z(), E(U, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(f).cancelCU, visible: s(f).status.cu > 0, title: s(f).status.title, "wrapper-closable": false, size: "860px" }, { titleRight: n(() => [o(a, { loading: s(f).status.cu === 2, type: "primary", size: "default", onClick: s(f).submitCU }, { default: n(() => t[1] || (t[1] = [v("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: n(() => [o(O, { ref_key: "formRef", ref: u, model: s(d), size: "default", "label-width": "140px" }, { default: n(() => [o(i, { ref_key: "detailRef", ref: k, border: "", data: s(d).list, "max-height": 300, style: { width: "100%" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": C }, { default: n(() => [o(l, { label: "序号", type: "index", align: "center", width: "55" }), o(l, { prop: "name", label: "签证原因", align: "center", "min-width": "270" }, { default: n((c) => [o(r, { modelValue: c.row.name, "onUpdate:modelValue": (y) => c.row.name = y, type: "text", placeholder: "签证原因", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(l, { label: "操作", align: "center" }, { default: n((c) => [o(a, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (y) => R(c.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"]), F("div", $, [o(a, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: t[0] || (t[0] = (c) => w()) }, { default: n(() => t[2] || (t[2] = [v("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, q = N(H, [["__scopeId", "data-v-6297b601"]]);
export {
  q as default
};
