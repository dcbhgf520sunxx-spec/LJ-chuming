import { ref as h } from "vue";
import { reactive as j } from "vue";
import { computed as P } from "vue";
import { onMounted as Q } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as y } from "vue";
import { createBlock as k } from "vue";
import { withCtx as s } from "vue";
import { createVNode as o } from "vue";
import { unref as d } from "vue";
import { createTextVNode as Y } from "vue";
import { withModifiers as G } from "vue";
import { createCommentVNode as J } from "vue";
import { isRef as K } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElForm as te } from "element-plus";
import { _ as ae, dS as le, u as se, o as ne, gI as re, b4 as de, aV as ie, aw as ue, V as me, hQ as ce } from "../../../../../../../shared/runtime.js";
import { u as pe } from "../../../../../../../modules/use-table-operate-4f84437f.js";
import { u as fe } from "../../../../../../../modules/use-add-form-local-storage-75741656.js";
const he = { __name: "batch-add", props: { modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue", "success"], setup(V, { emit: x }) {
  const _ = x, v = V, { workshops: U } = le(), c = h(false), I = h(true), n = j({ list: [] }), f = { common: { name: [{ required: true, max: 20, message: "不能为空", trigger: "blur" }], workshopUsers: [{ required: true, message: "不能为空", trigger: "blur" }] } }, C = P(() => f.common), b = /* @__PURE__ */ new Map([]), { visible: m, handleClose: w } = se({ emit: _, props: v }), { init: M, addRow: E, removeRow: R } = pe({}, 3, b), { tableValidate: T, cleanUpData: A, wrongCellMask: F } = ue({ rules: C, ditto: b }), { ADD_FORM: B, clearFormStorage: S } = fe("CLASSIFICATION_MATERIALTYPE", n, m);
  B.init = () => M(n.list);
  const { maxHeight: W } = ne({ mainBox: ".cls-batch-add", extraBox: [".el-dialog__header", ".header-operate"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, m);
  Q(() => {
    f.common = Object.assign(f.common), z();
  });
  const g = h([]);
  async function z() {
    const i = await re();
    g.value = i.content;
  }
  async function L() {
    try {
      c.value = true;
      const { validResult: i, dealList: l } = T(n.list);
      if (n.list = l, l.forEach((t) => {
        if (t.workshopType === 1) {
          if (t.workshopId) {
            const a = U.value.find((u) => t.workshopId === u.id);
            t.name = a.name;
          }
        } else t.workshopId = void 0;
      }), i) {
        const t = A(me(l)), a = [];
        t.forEach((u) => {
          u.name && a.push(u);
        }), await ce(a), S(), _("success"), X.success("添加成功"), w();
      }
    } catch (i) {
      console.log("仓库添加", i);
    } finally {
      c.value = false;
    }
  }
  return (i, l) => {
    const t = p("common-button"), a = Z, u = ee, N = p("common-select-v2"), D = oe, H = p("common-table"), O = te, $ = p("common-dialog");
    return y(), k($, { modelValue: d(m), "onUpdate:modelValue": l[1] || (l[1] = (e) => K(m) ? m.value = e : null), "before-close": d(w), "close-on-click-modal": false, "show-close": true, "custom-class": "cls-batch-add", title: "新增仓库", top: "10vh", width: "900px" }, { titleRight: s(() => [o(t, { icon: "el-icon-plus", size: "default", type: "success", onClick: l[0] || (l[0] = (e) => d(E)(n.list)) }), o(t, { loading: c.value, size: "default", type: "primary", onClick: L }, { default: s(() => l[2] || (l[2] = [Y("提 交")])), _: 1, __: [2] }, 8, ["loading"]), o(de, { type: "normal" })]), default: s(() => [o(O, { ref: "formRef", disabled: c.value, model: n }, { default: s(() => [I.value ? (y(), k(H, { key: 0, ref: "table", "cell-class-name": d(F), data: n.list, "max-height": d(W), "show-empty-symbol": false, "default-expand-all": "", "empty-text": "暂无数据", "return-source-data": "", "row-key": "uid" }, { default: s(() => [o(a, { align: "center", label: "序号", type: "index", width: "55" }), o(a, { key: "name", "show-overflow-tooltip": true, label: "仓库名称", prop: "name", "min-width": "200" }, { default: s(({ row: e }) => [o(u, { modelValue: e.name, "onUpdate:modelValue": (r) => e.name = r, modelModifiers: { trim: true }, placeholder: "仓库名称", size: "default", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "workshopUsers", "show-overflow-tooltip": true, clearable: "", label: "仓库负责人", prop: "workshopUsers", "min-width": "200" }, { default: s(({ row: e, $index: r }) => [o(N, { modelValue: e.workshopUsers, "onUpdate:modelValue": (q) => e.workshopUsers = q, dataStructure: { value: "id", label: "name", key: "id" }, options: g.value, "show-extra": r !== 0, showExtra: false, clearable: "", filterable: "", multiple: "", placeholder: "仓库负责人", size: "default", style: { width: "100%" }, type: "other" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), o(a, { key: "mesWorkshopId", "show-overflow-tooltip": true, clearable: "", label: "关联MES车间", prop: "mesWorkshopId", "min-width": "200" }, { default: s(({ row: e }) => [o(d(ie), { modelValue: e.mesWorkshopId, "onUpdate:modelValue": (r) => e.mesWorkshopId = r, placeholder: "请先选择车间", multiple: "", collapseTags: "", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { key: "sort", "show-overflow-tooltip": true, label: "排序", prop: "sort", width: "120" }, { default: s(({ row: e }) => [o(D, { modelValue: e.sort, "onUpdate:modelValue": (r) => e.sort = r, max: 999, min: 1, step: 1, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(a, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: s(({ $index: e }) => [o(t, { icon: "el-icon-delete", size: "default", style: { padding: "6px" }, type: "danger", onClick: G((r) => d(R)(n.list, e), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])) : J("", true)]), _: 1 }, 8, ["disabled", "model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ye = ae(he, [["__scopeId", "data-v-e1dfe8c1"]]);
export {
  ye as default
};
