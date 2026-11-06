import { ref as _ } from "vue";
import { reactive as q } from "vue";
import { computed as $ } from "vue";
import { onMounted as K } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as y } from "vue";
import { createBlock as w } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { unref as n } from "vue";
import { createTextVNode as P } from "vue";
import { withModifiers as X } from "vue";
import { createCommentVNode as Y } from "vue";
import { isRef as G } from "vue";
import { ElMessage as J } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElInputNumber as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { _ as oe, cP as V, u as te, o as ae, b4 as le, aw as se, V as ne, hR as ie } from "../../../../../../../shared/runtime.js";
import { u as re } from "../../../../../../../modules/use-table-operate-4f84437f.js";
import { u as de } from "../../../../../../../modules/use-add-form-local-storage-75741656.js";
const me = { __name: "batch-add", props: { modelValue: { type: Boolean, require: true }, workshop: { type: Object, default: () => ({}) } }, emits: ["update:modelValue", "success"], setup(x, { emit: v }) {
  const f = v, k = _([V.AUX_MANUFACTURED.K]), b = x, m = _(false), C = _(true), l = q({ list: [] }), p = { common: { name: [{ required: true, max: 20, message: "不能超过20个字符", trigger: "blur" }], materialType: [{ required: true, message: "不能为空", trigger: "change" }] } }, M = $(() => p.common), h = /* @__PURE__ */ new Map([]), { visible: d, handleClose: g } = te({ emit: f, props: b }), { init: R, addRow: T, removeRow: U } = re({}, 6, h), { tableValidate: E, cleanUpData: A, wrongCellMask: O } = se({ rules: M, ditto: h }), { ADD_FORM: F, clearFormStorage: I } = de("CLASSIFICATION_MEMORY", l, d);
  F.init = () => R(l.list);
  const { maxHeight: B } = ae({ mainBox: ".cls-batch-add", extraBox: [".el-dialog__header", ".header-operate"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, d);
  K(() => {
    p.common = Object.assign(p.common);
  });
  async function N() {
    try {
      m.value = true;
      const { validResult: u, dealList: t } = E(l.list);
      if (l.list = t, !u) return;
      const i = A(ne(t));
      i.forEach((s) => {
        s.workshopId = b.workshop.id;
      }), await ie(i), I(), f("success"), J.success("添加成功"), g();
    } catch (u) {
      console.log("仓库添加", u);
    } finally {
      m.value = false;
    }
  }
  return (u, t) => {
    const i = c("common-button"), s = Q, D = W, z = c("common-select"), H = Z, L = c("common-table"), S = ee, j = c("common-dialog");
    return y(), w(j, { modelValue: n(d), "onUpdate:modelValue": t[1] || (t[1] = (e) => G(d) ? d.value = e : null), "before-close": n(g), "close-on-click-modal": false, "show-close": true, "custom-class": "cls-batch-add", title: "新增存储位置", top: "10vh", width: "800px" }, { titleRight: a(() => [o(i, { icon: "el-icon-plus", size: "default", type: "success", onClick: t[0] || (t[0] = (e) => n(T)(l.list)) }), o(i, { loading: m.value, size: "default", type: "primary", onClick: N }, { default: a(() => t[2] || (t[2] = [P("提 交")])), _: 1, __: [2] }, 8, ["loading"]), o(le, { type: "normal" })]), default: a(() => [o(S, { ref: "formRef", disabled: m.value, model: l }, { default: a(() => [C.value ? (y(), w(L, { key: 0, ref: "table", "cell-class-name": n(O), data: l.list, "max-height": n(B), "show-empty-symbol": false, "default-expand-all": "", "empty-text": "暂无数据", "return-source-data": "", "row-key": "uid" }, { default: a(() => [o(s, { align: "center", label: "序号", type: "index", width: "55" }), o(s, { key: "name", "show-overflow-tooltip": true, label: "存储位置名称", prop: "name", "min-width": "170" }, { default: a(({ row: e }) => [o(D, { modelValue: e.name, "onUpdate:modelValue": (r) => e.name = r, modelModifiers: { trim: true }, placeholder: "存储位置名称", size: "default", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(s, { key: "materialType", "show-overflow-tooltip": true, label: "可存储材料类型", prop: "materialType", "min-width": "200" }, { default: a(({ row: e }) => [o(z, { modelValue: e.materialType, "onUpdate:modelValue": (r) => e.materialType = r, multiple: true, options: n(V).ENUM, unshowOptions: k.value, clearable: "", mode: "bit", placeholder: "可存储材料类型", style: { width: "100%" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshowOptions"])]), _: 1 }), o(s, { key: "sort", "show-overflow-tooltip": true, label: "排序", prop: "sort", width: "150" }, { default: a(({ row: e }) => [o(H, { modelValue: e.sort, "onUpdate:modelValue": (r) => e.sort = r, modelModifiers: { number: true }, max: 999, min: 1, step: 1, "controls-position": "right", style: { width: "120px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(s, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: a(({ $index: e }) => [o(i, { icon: "el-icon-delete", size: "default", style: { padding: "6px" }, type: "danger", onClick: X((r) => n(U)(l.list, e), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])) : Y("", true)]), _: 1 }, 8, ["disabled", "model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, fe = oe(me, [["__scopeId", "data-v-ee9bd303"]]);
export {
  fe as default
};
