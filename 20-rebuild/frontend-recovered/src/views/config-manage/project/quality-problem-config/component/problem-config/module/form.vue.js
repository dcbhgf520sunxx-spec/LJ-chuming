import { useStore as E } from "vuex";
import { ref as b } from "vue";
import { ElMessage as g } from "element-plus";
import { resolveComponent as m } from "vue";
import { openBlock as F } from "vue";
import { createBlock as B } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as s } from "vue";
import { createTextVNode as v } from "vue";
import { createElementVNode as S } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElForm as N } from "element-plus";
import { _ as T, ao as $, fK as h } from "../../../../../../../shared/runtime.js";
const H = { class: "add-row-box" }, I = { __name: "form", setup(M) {
  const x = E(), u = b(), k = b(), C = { list: [] }, { CRUD: p, crud: c, form: d } = $(C, u), _ = { name: [{ required: true, message: "请输入问题分类", trigger: "blur" }] };
  function w({ row: e, column: t }) {
    if (!e) return;
    const a = _;
    let o = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (o = h(t.property, a[t.property], e)), o && (e.verify[t.property] = true)), o ? "" : "mask-td";
  }
  function R(e) {
    d.list.splice(e, 1);
  }
  function V() {
    d.list.push({ name: void 0 });
  }
  p.HOOK.beforeValidateCU = (e, t) => {
    if (e.form.list.length <= 0) return g({ message: "请先填写问题分类明细", type: "error" }), false;
    const a = _;
    let o = true;
    if (e.form.list.map((r) => {
      r.verify = {};
      for (const i in a) r.verify[i] = h(i, a[i], r), r.verify[i] || (o = false);
    }), !o) return g.error("请填写表格中标红数据"), false;
  };
  async function O() {
    try {
      await x.dispatch("config/fetchQualityProblemType");
    } catch (e) {
      console.log(e);
    }
  }
  return p.HOOK.afterSubmit = () => {
    O();
  }, (e, t) => {
    const a = m("common-button"), o = j, r = K, i = m("common-table"), U = N, z = m("common-drawer");
    return F(), B(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(c).cancelCU, visible: s(c).status.cu > 0, title: s(c).status.title, "wrapper-closable": false, size: "860px" }, { titleRight: n(() => [l(a, { loading: s(c).status.cu === 2, type: "primary", size: "default", onClick: s(c).submitCU }, { default: n(() => t[1] || (t[1] = [v("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: n(() => [l(U, { ref_key: "formRef", ref: u, model: s(d), size: "default", "label-width": "140px" }, { default: n(() => [l(i, { ref_key: "detailRef", ref: k, border: "", data: s(d).list, "max-height": 300, style: { width: "100%" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": w }, { default: n(() => [l(o, { label: "序号", type: "index", align: "center", width: "55" }), l(o, { prop: "name", label: "问题分类", align: "center", "min-width": "270" }, { default: n((f) => [l(r, { modelValue: f.row.name, "onUpdate:modelValue": (y) => f.row.name = y, type: "text", placeholder: "问题分类", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(o, { label: "操作", align: "center" }, { default: n((f) => [l(a, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (y) => R(f.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"]), S("div", H, [l(a, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: t[0] || (t[0] = (f) => V()) }, { default: n(() => t[2] || (t[2] = [v("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, P = T(I, [["__scopeId", "data-v-1aa9188d"]]);
export {
  P as default
};
