import { useStore as E } from "vuex";
import { ref as m } from "vue";
import { ElMessage as x } from "element-plus";
import { resolveComponent as u } from "vue";
import { openBlock as F } from "vue";
import { createBlock as S } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { unref as r } from "vue";
import { createTextVNode as h } from "vue";
import { createElementVNode as M } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElForm as N } from "element-plus";
import { _ as T, ao as $, o as I, fK as v } from "../../../../../../../shared/runtime.js";
const q = { class: "add-row-box" }, D = { __name: "form", setup(A) {
  const k = E(), p = m(), w = m(), _ = m(), C = { list: [] }, { CRUD: y, crud: c, form: d } = $(C, p), { maxHeight: R } = I({ mainBox: ".config-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, extraHeight: 80, minHeight: 300 }, () => _.value.loaded), g = { name: [{ required: true, message: "请输入分包类别", trigger: "blur" }] };
  function H({ row: e, column: t }) {
    if (!e) return;
    const l = g;
    let a = true;
    return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[t.property] === false && (a = v(t.property, l[t.property], e)), a && (e.verify[t.property] = true)), a ? "" : "mask-td";
  }
  function V(e) {
    d.list.splice(e, 1);
  }
  function B() {
    d.list.push({ name: void 0 });
  }
  y.HOOK.beforeValidateCU = (e, t) => {
    if (e.form.list.length <= 0) return x({ message: "请先填写分包类别明细", type: "error" }), false;
    const l = g;
    let a = true;
    if (e.form.list.map((s) => {
      s.verify = {};
      for (const i in l) s.verify[i] = v(i, l[i], s), s.verify[i] || (a = false);
    }), !a) return x.error("请填写表格中标红数据"), false;
  };
  async function O() {
    try {
      await k.dispatch("config/fetchSubcontractType");
    } catch (e) {
      console.log(e);
    }
  }
  return y.HOOK.afterSubmit = () => {
    O();
  }, (e, t) => {
    const l = u("common-button"), a = j, s = K, i = u("common-table"), U = N, z = u("common-drawer");
    return F(), S(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": r(c).cancelCU, visible: r(c).status.cu > 0, title: r(c).status.title, "wrapper-closable": false, "custom-class": "config-detail", ref_key: "drawerRef", ref: _, size: "860px" }, { titleRight: n(() => [o(l, { loading: r(c).status.cu === 2, type: "primary", size: "default", onClick: r(c).submitCU }, { default: n(() => t[1] || (t[1] = [h("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: n(() => [o(U, { ref_key: "formRef", ref: p, model: r(d), size: "default", "label-width": "140px" }, { default: n(() => [o(i, { ref_key: "detailRef", ref: w, border: "", data: r(d).list, "max-height": r(R), style: { width: "100%" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": H }, { default: n(() => [o(a, { label: "序号", type: "index", align: "center", width: "55" }), o(a, { prop: "name", label: "分包类别", align: "center", "min-width": "270" }, { default: n((f) => [o(s, { modelValue: f.row.name, "onUpdate:modelValue": (b) => f.row.name = b, type: "text", placeholder: "分包类别", style: { width: "260px" }, maxlength: "50" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { label: "操作", align: "center" }, { default: n((f) => [o(l, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (b) => V(f.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), M("div", q, [o(l, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-right": "15px" }, onClick: t[0] || (t[0] = (f) => B()) }, { default: n(() => t[2] || (t[2] = [h("继续添加")])), _: 1, __: [2] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, L = T(D, [["__scopeId", "data-v-033f1674"]]);
export {
  L as default
};
