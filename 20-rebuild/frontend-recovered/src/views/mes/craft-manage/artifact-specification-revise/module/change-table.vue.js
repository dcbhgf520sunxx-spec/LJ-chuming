import { ref as i } from "vue";
import { inject as D } from "vue";
import { watch as O } from "vue";
import { nextTick as $ } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as y } from "vue";
import { createBlock as S } from "vue";
import { withCtx as r } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as F } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as G } from "vue";
import { isRef as J } from "vue";
import { ElNotification as K } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElInput as W } from "element-plus";
import { l as f, _ as X, u as Y, o as Z, V as k, aI as ee, aw as te } from "../../../../../shared/runtime.js";
function oe(l) {
  return f({ module: "plan", url: "artifact/list-specAmend", method: "get", params: l });
}
function P(l) {
  return f({ module: "plan", url: "artifact/save-specAmend", method: "put", data: l.list });
}
function re(l) {
  return f({ module: "", url: "/api/system/structure-classification/list-specPrefix", method: "get", params: l });
}
function ce(l) {
  return f({ module: "", url: "/api/plan/artifact/list-spec", method: "get", params: l });
}
const ie = { get: oe, edit: P };
const ae = { __name: "change-table", props: { modelValue: { type: Boolean, require: true }, list: { type: Array, default: () => [] } }, emits: ["success", "update:modelValue"], setup(l, { emit: R }) {
  const p = l, C = i(), s = i([]), v = R, { visible: w, handleClose: x } = Y({ emit: v, props: p }), _ = i(false), V = i(), b = i(true), T = D("specList"), M = { newSpecPrefix: [{ required: true, message: "请选择截面定义", trigger: "change" }], newSpecSection: [{ required: true, max: 30, message: "不能超过30个字符", trigger: "blur" }] }, h = /* @__PURE__ */ new Map([["newSpecPrefix", -1], ["newSpecSection", "同上"]]), { tableValidate: U, cleanUpData: q, wrongCellMask: B } = te({ rules: M, ditto: h });
  O(() => p.list, (t) => {
    t && (s.value = [], N());
  }, { deep: true, immediate: true });
  const { maxHeight: L } = Z({ mainBox: ".spec-change-form", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, minHeight: 300 }, () => V.value.loaded);
  function N() {
    for (let t = 0; t < p.list.length; t++) E(t);
    b.value = false, $(() => {
      b.value = true;
    });
  }
  function E(t) {
    const o = k(p.list[t]);
    o.uid = ee(), h && s.value.length > 0 && h.forEach((d, e) => {
      o[e] || (o[e] = d);
    }), s.value.push(o);
  }
  async function H() {
    _.value = true;
    try {
      const { validResult: t, dealList: o } = U(s.value);
      if (s.value = o, t) {
        const e = q(k(o)).map((c) => ({ id: c.id, newSpecPrefix: c.newSpecPrefix, newSpecSection: c.newSpecSection }));
        await P({ list: e }), j();
      }
    } catch (t) {
      console.log("构件规格修改", t);
    } finally {
      _.value = false;
    }
  }
  function j() {
    K({ title: "修正成功", type: "success" }), v("success"), x();
  }
  return (t, o) => {
    const d = m("common-button"), e = Q, c = m("common-select"), A = W, I = m("common-table"), z = m("common-drawer");
    return y(), S(z, { ref_key: "drawerRef", ref: V, "append-to-body": "", "close-on-click-modal": false, "before-close": u(x), modelValue: u(w), "onUpdate:modelValue": o[0] || (o[0] = (n) => J(w) ? w.value = n : null), title: "规格修正", "wrapper-closable": false, size: "85%", "custom-class": "spec-change-form" }, { titleRight: r(() => [a(d, { type: "success", size: "default", loading: _.value, onClick: H }, { default: r(() => o[1] || (o[1] = [F("保存")])), _: 1, __: [1] }, 8, ["loading"])]), content: r(() => [b.value ? (y(), S(I, { key: 0, ref_key: "tableRef", ref: C, border: "", data: s.value, "max-height": u(L), style: { width: "100%" }, class: "table-form", stripe: false, "return-source-data": "", "cell-class-name": u(B), showEmptySymbol: false }, { default: r(() => [a(e, { label: "序号", type: "index", align: "center", width: "55" }), a(e, { key: "monomer.name", prop: "monomer.name", label: "单体", "show-overflow-tooltip": "" }), a(e, { key: "area.name", prop: "area.name", label: "区域", "show-overflow-tooltip": "" }), a(e, { key: "name", prop: "name", label: "名称", "show-overflow-tooltip": "" }), a(e, { key: "serialNumber", prop: "serialNumber", label: "编号", "show-overflow-tooltip": "" }), a(e, { key: "newSpecPrefix", prop: "newSpecPrefix", label: "截面定义", "show-overflow-tooltip": "" }, { default: r((n) => [(y(), S(c, { key: Math.random(), modelValue: n.row.newSpecPrefix, "onUpdate:modelValue": (g) => n.row.newSpecPrefix = g, options: u(T), "show-extra": n.$index !== 0, type: "other", filterable: "", clearable: "", dataStructure: { key: "id", label: "value", value: "id" }, placeholder: "截面定义" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"]))]), _: 1 }), a(e, { key: "oldSpecification", prop: "oldSpecification", label: "原规格", "show-overflow-tooltip": "" }), a(e, { key: "newSpecSection", prop: "newSpecSection", label: "规格", "show-overflow-tooltip": "" }, { default: r((n) => [a(A, { modelValue: n.row.newSpecSection, "onUpdate:modelValue": (g) => n.row.newSpecSection = g, modelModifiers: { trim: true }, placeholder: "例如:400*200*10*12", type: "text", maxlength: 30 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(e, { key: "quantity", prop: "quantity", label: "清单数", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])) : G("", true)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, le = X(ae, [["__scopeId", "data-v-ad0ef7b1"]]), ue = Object.freeze(Object.defineProperty({ __proto__: null, default: le }, Symbol.toStringTag, { value: "Module" }));
export {
  le as a,
  ue as b,
  ie as c,
  ce as g,
  re as s
};
