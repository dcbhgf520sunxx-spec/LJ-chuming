import { ref as i } from "vue";
import { watch as R } from "vue";
import { computed as te } from "vue";
import { watchEffect as ae } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as ne } from "vue";
import { createBlock as oe } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as z } from "vue";
import { createElementVNode as y } from "vue";
import { normalizeClass as I } from "vue";
import { toDisplayString as C } from "vue";
import { unref as Q } from "vue";
import { ElMessage as w } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElDescriptionsItem as ue } from "element-plus";
import { ElDatePicker as ie } from "element-plus";
import { ElDescriptions as re } from "element-plus";
import { ElForm as de } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { ElInput as pe } from "element-plus";
import { _ as me, u as fe, o as ve } from "../../../../../shared/runtime.js";
import { u as _e } from "../../../../../modules/use-scheduling-groups-b1c4e979.js";
import { a as be } from "../../../../../modules/scheduling-manage-9a6dc016.js";
const ge = { class: "header", style: { "margin-bottom": "10px" } }, he = { style: { "padding-left": "12px" } }, ye = { style: { "padding-left": "12px" } }, Ie = { __name: "collect", props: { modelValue: { type: Boolean, default: false }, collectList: { type: Array, default: () => [] }, dictionaryId: { type: Number } }, emits: ["update:modelValue", "updateList", "success"], setup(F, { emit: H }) {
  const m = F, v = H, { visible: U, handleClose: T } = fe({ emit: v, props: m, closeHook: M }), n = i([]), E = i(), N = i(), s = i({ workshopId: void 0, askCompleteTime: void 0, productionLineId: void 0, teamId: void 0 }), j = i({ workshopId: [{ required: true, message: "请选择车间", trigger: "blur" }], productionLineId: [{ required: true, message: "请选择产线", trigger: "blur" }], askCompleteTime: [{ required: true, message: "请选择日期", trigger: "blur" }], teamId: [{ required: true, message: "请选择日期", trigger: "blur" }] });
  function M() {
    Object.keys(s.value).forEach((l) => {
      s.value[l] = void 0;
    });
  }
  const { maxHeight: P } = ve({ mainBox: ".collect-drawer", extraBox: [".el-drawer__header", ".header"], wrapperBox: ".el-drawer__body", minHeight: 300, navbar: false, clientHRepMainH: true }, E);
  function S(l) {
    const e = n.value.findIndex((o) => o.id === l.id);
    e !== -1 && (n.value.splice(e, 1), v("updateList", n.value));
  }
  function $() {
    n.value = [], v("updateList", n.value);
  }
  R(() => m.collectList, (l) => {
    n.value = l;
  }, { deep: true });
  const A = te(() => {
    var l;
    if ((l = m.dictionaryId) != null && l.length) return { type: m.dictionaryId[0] };
  }), { groupsTree: k } = _e({ queryParams: A }), _ = i([]), q = i();
  ae(() => {
    var l, e;
    k.value && (q.value = (l = k.value[0]) == null ? void 0 : l.id, _.value = (e = k.value[0]) == null ? void 0 : e.children);
  });
  const f = i([]);
  function G(l) {
    const e = _.value.findIndex((o) => o.id === l);
    e !== -1 ? f.value = _.value[e].children : f.value = [];
  }
  const x = i([]);
  function O(l) {
    const e = f.value.findIndex((o) => o.id === l);
    e !== -1 ? x.value = f.value[e].children : x.value = [];
  }
  const b = i(), g = i();
  function B() {
    var l, e;
    ((l = n.value) == null ? void 0 : l.length) > 1 ? b.value = n.value.reduce((o, c) => {
      const d = Number(c.newQuantity) || 0;
      return o + d;
    }, 0) : ((e = n.value) == null ? void 0 : e.length) === 1 ? b.value = Number(n.value[0].newQuantity) || 0 : b.value = 0;
  }
  function D() {
    var l, e;
    ((l = n.value) == null ? void 0 : l.length) > 1 ? g.value = n.value.reduce((o, c) => {
      const d = Number(c.totalLength) || 0;
      return o + d;
    }, 0) / 1e3 : ((e = n.value) == null ? void 0 : e.length) === 1 ? g.value = (Number(n.value[0].totalLength) || 0) / 1e3 : g.value = 0;
  }
  R(n, (l) => {
    B(), D();
  }, { deep: true, immediate: true });
  const L = i();
  async function W() {
    await N.value.validate();
    const l = n.value.map((e) => ({ productId: e.id, quantity: parseFloat(e.newQuantity) }));
    try {
      L.value = true, await be({ ...s.value, schedulings: l, dictionaryId: m.dictionaryId[0], projectId: n.value[0].projectId, factoryId: q.value }), w.success("操作成功"), T(), v("success");
    } catch (e) {
      console.log(e);
    } finally {
      L.value = false;
    }
  }
  function J(l) {
    const e = parseInt(l.newQuantity, 10), o = parseFloat(l.needSchedulingQuantity);
    if (isNaN(e)) {
      l.newQuantity = null, l.totalLength = null, w.warning("请输入有效的数字");
      return;
    }
    if (e < 1) l.newQuantity = 1, w.warning("输入值不能小于 1");
    else if (o && e > o) return l.newQuantity = o, w.warning(`输入值不能大于 ${o}`);
    l.newQuantity = e, l.totalLength = l.length * l.newQuantity, B(), D();
  }
  return (l, e) => {
    const o = h("common-button"), c = h("common-select-v2"), d = se, p = ue, K = ie, X = re, Y = de, r = ce, Z = pe, ee = h("common-table"), le = h("common-drawer");
    return ne(), oe(le, { "before-close": Q(T), visible: Q(U), "custom-class": "collect-drawer", size: "100%", title: "生产排产" }, { titleRight: a(() => [t(o, { size: "default", type: "danger", onClick: $ }, { default: a(() => e[4] || (e[4] = [z("一键删除")])), _: 1, __: [4] }), t(o, { loading: L.value, size: "default", type: "success", onClick: W }, { default: a(() => e[5] || (e[5] = [z("任务下发")])), _: 1, __: [5] }, 8, ["loading"])]), content: a(() => [y("div", ge, [t(Y, { ref_key: "formRef", ref: N, model: s.value, rules: j.value }, { default: a(() => [t(X, { column: 3, "label-width": 140, border: "" }, { default: a(() => [t(p, { label: "车间", "label-class-name": "label-item verify" }, { default: a(() => [t(d, { class: I({ "error-placeholder": !s.value.workshopId }), prop: "workshopId" }, { default: a(() => [t(c, { modelValue: s.value.workshopId, "onUpdate:modelValue": e[0] || (e[0] = (u) => s.value.workshopId = u), options: _.value, class: "input-border-none", placeholder: "请选择车间", style: { width: "100%" }, onChange: G }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["class"])]), _: 1 }), t(p, { label: "产线", "label-class-name": "label-item verify" }, { default: a(() => [t(d, { class: I({ "error-placeholder": !s.value.productionLineId }), prop: "productionLineId" }, { default: a(() => [t(c, { modelValue: s.value.productionLineId, "onUpdate:modelValue": e[1] || (e[1] = (u) => s.value.productionLineId = u), options: f.value, class: "input-border-none", placeholder: "请选择产线", style: { width: "100%" }, onChange: O }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["class"])]), _: 1 }), t(p, { label: "班组", "label-class-name": "label-item verify" }, { default: a(() => [t(d, { class: I({ "error-placeholder": !s.value.teamId }), prop: "teamId" }, { default: a(() => [t(c, { modelValue: s.value.teamId, "onUpdate:modelValue": e[2] || (e[2] = (u) => s.value.teamId = u), options: x.value, class: "input-border-none", placeholder: "请选择班组", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["class"])]), _: 1 }), t(p, { label: "完成日期", "label-class-name": "label-item verify", width: "400px" }, { default: a(() => [t(d, { class: I({ "error-placeholder": !s.value.askCompleteTime }), prop: "askCompleteTime" }, { default: a(() => [t(K, { modelValue: s.value.askCompleteTime, "onUpdate:modelValue": e[3] || (e[3] = (u) => s.value.askCompleteTime = u), class: "input-border-none", placeholder: "请选择日期", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["class"])]), _: 1 }), t(p, { label: "数量", "label-class-name": "label-item" }, { default: a(() => [y("span", he, C(b.value), 1)]), _: 1 }), t(p, { label: "总长度(m)", "label-class-name": "label-item" }, { default: a(() => [y("span", ye, C(g.value), 1)]), _: 1 }), t(p, { label: "工单编号", "label-class-name": "label-item" })]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), t(ee, { ref_key: "tableRef", ref: E, data: n.value, "max-height": Q(P), "return-source-data": true }, { default: a(() => [t(r, { align: "center", label: "序号", type: "index", width: "60" }), t(r, { align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), t(r, { align: "center", label: "名称", prop: "name", "show-overflow-tooltip": "" }), t(r, { align: "center", label: "规格", prop: "plate" }), t(r, { align: "center", label: "有效宽度", prop: "width" }), t(r, { align: "center", label: "厚度（mm）", prop: "thickness" }), t(r, { align: "center", label: "单长（mm）", prop: "length" }), t(r, { align: "center", label: "计量单位", prop: "unit" }), t(r, { align: "center", label: "数量", prop: "quantity" }, { default: a(({ row: u }) => [t(Z, { modelValue: u.newQuantity, "onUpdate:modelValue": (V) => u.newQuantity = V, placeholder: "数量", type: "number", onInput: (V) => J(u) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }), t(r, { align: "center", label: "总长度(m)", prop: "totalLength" }, { default: a(({ row: u }) => [y("span", null, C(u.totalLength / 1e3), 1)]), _: 1 }), t(r, { align: "center", label: "操作", width: "80" }, { default: a(({ row: u }) => [t(o, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (V) => S(u) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Ve = me(Ie, [["__scopeId", "data-v-abf57b02"]]);
export {
  Ve as default
};
