import { ref as u } from "vue";
import { computed as b } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as D } from "vue";
import { createBlock as L } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as g } from "vue";
import { createElementVNode as q } from "vue";
import { unref as a } from "vue";
import { ElMessage as j } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElCascader as Q } from "element-plus";
import { ElForm as G } from "element-plus";
import { _ as J, o as W, ao as X, cP as Y, de as Z, aw as ee, df as le } from "../../../../../shared/runtime.js";
import { u as te } from "../../../../../modules/use-table-operate-4f84437f.js";
const ae = { class: "add-row-box" }, se = { __name: "form", setup(oe) {
  const f = u(), y = u(), h = { list: [] }, { maxHeight: C } = W({ wrapperBox: ".auditAddForm", paginate: true, extraHeight: 40 }), { CRUD: v, crud: c, form: i } = X(h, f), x = {}, V = { density: [{ required: true, message: "请输入密度", trigger: "blur" }], classifyId: [{ required: true, message: "请选择科目", trigger: "change" }] }, w = /* @__PURE__ */ new Map([]), { init: k, addRow: R, removeRow: U } = te({}, 5, w), { tableValidate: E, wrongCellMask: O, cleanUpData: T } = ee({ rules: V }), p = u(false), _ = u([]), S = b(() => ({ value: "id", label: "className", children: "children", expandTrigger: "hover", emitPath: false, multiple: false, checkStrictly: true })), F = b(() => [Y.STEEL_PLATE]);
  v.HOOK.beforeToAdd = () => {
    k(i.list), I();
  };
  async function I() {
    _.value = await Z();
  }
  function z(d) {
    var t;
    d.steelClassOptions = (t = _.value) == null ? void 0 : t.filter((o) => o.basicClass === d.basicClass);
  }
  async function B() {
    p.value = true;
    try {
      const { validResult: d, dealList: t } = E(i.list);
      d && (T(t), await le(t).then((o) => {
        o && (j.success("提交成功"), c.cancelCU(), c.toQuery());
      }));
    } finally {
      p.value = false;
    }
  }
  return (d, t) => {
    const o = m("common-button"), r = K, M = m("common-select"), H = Q, N = m("common-input-number"), P = m("common-table"), $ = G, A = m("common-dialog");
    return D(), L(A, { "before-close": a(c).cancelCU, "close-on-click-modal": false, title: a(c).status.title, visible: a(c).status.cu > 0, "append-to-body": "", top: "5vh", width: "800px" }, { titleRight: s(() => [l(o, { loading: p.value, size: "mini", type: "primary", onClick: B }, { default: s(() => t[1] || (t[1] = [g(" 确认")])), _: 1, __: [1] }, 8, ["loading"])]), default: s(() => [q("div", ae, [l(o, { icon: "el-icon-circle-plus", size: "mini", type: "success", onClick: t[0] || (t[0] = (e) => a(R)(a(i).list)) }, { default: s(() => t[2] || (t[2] = [g(" 添加 ")])), _: 1, __: [2] })]), l($, { ref_key: "formRef", ref: f, model: a(i), rules: x, "label-width": "130px", size: "small" }, { default: s(() => [l(P, { ref_key: "detailRef", ref: y, "cell-class-name": a(O), data: a(i).list, "max-height": a(C), showEmptySymbol: false, stripe: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%", "margin-top": "10px" } }, { default: s(() => [l(r, { align: "center", label: "序号", type: "index", width: "50" }), l(r, { key: "type", align: "center", label: "材料类型", "min-width": "100", prop: "type" }, { default: s(({ row: e }) => [l(M, { modelValue: e.basicClass, "onUpdate:modelValue": (n) => e.basicClass = n, options: F.value, class: "input-underline", clearable: "", placeholder: "材料类型", type: "enum", onChange: (n) => z(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), l(r, { key: "classifyId", align: "center", label: "科目", "min-width": "200", prop: "classifyId" }, { default: s(({ row: e }) => [l(H, { modelValue: e.classifyId, "onUpdate:modelValue": (n) => e.classifyId = n, options: e.steelClassOptions, props: S.value, "show-all-levels": false, class: "input-underline", clearable: "", filterable: "", placeholder: "科目、编号", separator: " > " }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "props"])]), _: 1 }), l(r, { key: "density", align: "center", label: "密度", "min-width": "100", prop: "density" }, { default: s(({ row: e }) => [l(N, { modelValue: e.density, "onUpdate:modelValue": (n) => e.density = n, controls: false, max: 999999, min: 0.01, class: "input-underline", "controls-position": "right", placeholder: "密度", size: "mini" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(r, { align: "center", label: "操作", width: "100" }, { default: s((e) => [l(o, { icon: "el-icon-delete", size: "small", type: "danger", onClick: (n) => a(U)(a(i).list, e.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, de = J(se, [["__scopeId", "data-v-8db422d8"]]);
export {
  de as default
};
