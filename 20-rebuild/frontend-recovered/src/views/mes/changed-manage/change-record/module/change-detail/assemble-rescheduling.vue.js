import { ref as w } from "vue";
import { inject as U } from "vue";
import { watchEffect as le } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as B } from "vue";
import { createBlock as te } from "vue";
import { withCtx as u } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as C } from "vue";
import { createTextVNode as ae } from "vue";
import { unref as v } from "vue";
import M from "moment";
import { createElementBlock as ne } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as oe } from "vue";
import { ElMessage as ie } from "element-plus";
import { ElDivider as se } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElInputNumber as ue } from "element-plus";
import { ElTooltip as re } from "element-plus";
import { ElCascader as pe } from "element-plus";
import { ElDatePicker as ce } from "element-plus";
import { ElCard as me } from "element-plus";
import { m as he } from "../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import { a3 as ge, V as z, p as fe, aw as be, b as ye } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
const we = { key: 0 }, i = "assemble", Se = { __name: "assemble-rescheduling", setup(ve) {
  const P = ge.ASSEMBLE.V, b = w({}), k = w([]), T = w([]), S = w([]), q = U("schedulingInfo"), o = U("schedulingHandle"), A = { needSchedulingQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, $ = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: F, cleanUpData: G, wrongCellMask: H } = be({ rules: A, ditto: $ });
  W(), le(() => {
    var d, e, c;
    const n = [], s = [], r = z(q.value.assembleList);
    for (let g = 0; g < r.length; g++) {
      const a = r[g];
      let m = a.originQuantity;
      if (!((e = (d = o.value) == null ? void 0 : d[i]) != null && e[a.rowKey])) n.length && (a.groupsId = a.groupsId ? a.groupsId : "同上", a.askCompleteTime = a.askCompleteTime ? a.askCompleteTime : "同上"), n.push({ ...a, needSchedulingQuantity: m, maxQuantity: m });
      else {
        for (const f in (c = o.value[i][a.rowKey]) == null ? void 0 : c.handleObj) if (Object.hasOwnProperty.call(o.value[i][a.rowKey].handleObj, f)) {
          const y = o.value[i][a.rowKey].handleObj[f];
          s.push({ ...a, ...y }), m -= y.needSchedulingQuantity;
        }
        m > 0 && (n.length && (a.groupsId = a.groupsId ? a.groupsId : "同上", a.askCompleteTime = a.askCompleteTime ? a.askCompleteTime : "同上"), n.push({ ...a, needSchedulingQuantity: m, maxQuantity: m }));
      }
    }
    T.value = n, S.value = s, o.value[i + "NeedSchedulingList"] = n;
  });
  async function W() {
    b.value = await he({ productType: P }, true);
  }
  function Y(n, s, r) {
    r !== 0 && !n && (s.groupsId = "同上");
  }
  function J(n, s, r) {
    r !== 0 && !n && (s.askCompleteTime = "同上");
  }
  function X(n) {
    k.value = n;
  }
  function Z() {
    if (!k.value.length) {
      ie.warning("请至少选择一条数据");
      return;
    }
    const { validResult: n, dealList: s } = F(k.value);
    if (n) {
      const r = z(s);
      G(r), r.forEach((d) => {
        var g, a, m, f;
        const e = d.rowKey, c = `${d.groupsId}`;
        (a = (g = o.value) == null ? void 0 : g[i]) != null && a[e] ? (o.value[i][e].needSchedulingQuantity += d.needSchedulingQuantity, (f = (m = o.value) == null ? void 0 : m[i]) != null && f[e].handleObj[c] ? (o.value[i][e].handleObj[c].needSchedulingQuantity += d.needSchedulingQuantity, o.value[i][e].handleObj[c].askCompleteTime = Math.max(d.askCompleteTime, o.value[i][e].handleObj[c].askCompleteTime)) : o.value[i][e].handleObj[c] = { groupsId: d.groupsId, askCompleteTime: d.askCompleteTime, needSchedulingQuantity: d.needSchedulingQuantity }) : o.value[i][e] = { ...d, handleObj: { [c]: { groupsId: d.groupsId, askCompleteTime: d.askCompleteTime, needSchedulingQuantity: d.needSchedulingQuantity } } };
      });
    }
  }
  function ee(n) {
    const s = `${n.groupsId}`;
    o.value[i][n.rowKey] && (o.value[i][n.rowKey].handleObj[s] && (o.value[i][n.rowKey].needSchedulingQuantity -= o.value[i][n.rowKey].handleObj[s].needSchedulingQuantity, delete o.value[i][n.rowKey].handleObj[s]), ye(o.value[i][n.rowKey].handleObj) && delete o.value[i][n.rowKey]);
  }
  return (n, s) => {
    const r = se, d = R("common-button"), e = de, c = ue, g = re, a = pe, m = ce, f = R("common-table"), y = me;
    return B(), te(y, null, { default: u(() => [l(r, null, { default: u(() => s[0] || (s[0] = [C("span", { class: "title", style: { padding: "5px 50px" } }, "部件排产列表", -1)])), _: 1, __: [0] }), l(d, { type: "success", size: "default", style: { "margin-bottom": "10px" }, onClick: Z }, { default: u(() => s[1] || (s[1] = [ae("加入下发列表")])), _: 1, __: [1] }), l(f, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: T.value, "cell-class-name": v(H), style: { width: "100%", "margin-bottom": "50px" }, onSelectionChange: X }, { default: u(() => [l(e, { type: "selection", align: "center", width: "60" }), l(e, { label: "序号", type: "index", align: "center", width: "60" }), l(e, { label: "区域", prop: "area.name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "变更构件编号", prop: "artifactSerialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "变更部件编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "left", "min-width": "120" }), l(e, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "110" }), l(e, { label: "单重(kg)", prop: "netWeight", "show-overflow-tooltip": "", align: "center", "min-width": "110" }), l(e, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: u(({ row: { sourceRow: t } }) => [l(g, { class: "item", effect: "dark", content: `变更清单数量：${t.originQuantity} ${t.maxQuantity < t.originQuantity ? "，已加入下发数量：" + (t.originQuantity - t.maxQuantity) : ""}`, placement: "top" }, { default: u(() => [l(c, { modelValue: t.needSchedulingQuantity, "onUpdate:modelValue": (h) => t.needSchedulingQuantity = h, step: 1, min: 0, max: t.maxQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 2 }, 1032, ["content"])]), _: 1 }), l(e, { "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: u(({ row: { sourceRow: t }, $index: h }) => [l(a, { modelValue: t.groupsId, "onUpdate:modelValue": (p) => t.groupsId = p, options: b.value.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, filterable: "", clearable: "", style: { width: "100%" }, placeholder: h === 0 ? "请选择生产组" : "同上", onChange: (p) => Y(p, t, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])]), _: 1 }), l(e, { prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "130px" }, { default: u(({ row: { sourceRow: t }, $index: h }) => [l(m, { modelValue: t.askCompleteTime, "onUpdate:modelValue": (p) => t.askCompleteTime = p, type: "date", size: "default", "value-format": "x", style: { width: "100%" }, disabledDate: (p) => v(M)(p).valueOf() < v(M)().subtract(1, "days").valueOf(), placeholder: h === 0 ? "需求完成日期" : "同上", onChange: (p) => J(p, t, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "placeholder", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), l(r, null, { default: u(() => s[2] || (s[2] = [C("span", { class: "title", style: { padding: "5px 50px" } }, "部件下发列表", -1)])), _: 1, __: [2] }), l(f, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: S.value, style: { width: "100%" } }, { default: u(() => [l(e, { width: "60", align: "center" }, { default: u(({ row: t }) => [l(d, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: (h) => ee(t) }, null, 8, ["onClick"])]), _: 1 }), l(e, { label: "序号", type: "index", align: "center", width: "60" }), l(e, { label: "区域", prop: "area.name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "变更构件编号", prop: "artifactSerialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "变更部件编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "left", "min-width": "120" }), l(e, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "110" }), l(e, { label: "单重(kg)", prop: "netWeight", "show-overflow-tooltip": "", align: "center", "min-width": "110" }), l(e, { label: "数量", prop: "needSchedulingQuantity", "show-overflow-tooltip": "", align: "center", "min-width": "90" }), l(e, { label: "生产组", prop: "groupsId", "show-overflow-tooltip": "", align: "center", "min-width": "150" }, { default: u(({ row: t }) => {
      var h, p, Q, I, x, j, V, O, E, K, L, N, D;
      return [(p = (h = b.value) == null ? void 0 : h.obj) != null && p[t.groupsId] ? (B(), ne("span", we, _((j = (x = (I = (Q = b.value) == null ? void 0 : Q.obj) == null ? void 0 : I[t.groupsId]) == null ? void 0 : x.workshop) == null ? void 0 : j.name) + "/" + _((K = (E = (O = (V = b.value) == null ? void 0 : V.obj) == null ? void 0 : O[t.groupsId]) == null ? void 0 : E.productionLine) == null ? void 0 : K.name) + "/" + _((D = (N = (L = b.value) == null ? void 0 : L.obj) == null ? void 0 : N[t.groupsId]) == null ? void 0 : D.groupsName), 1)) : oe("", true)];
    }), _: 1 }), l(e, { label: "要求完成日期", prop: "askCompleteTime", "show-overflow-tooltip": "", align: "center", "min-width": "130" }, { default: u(({ row: t }) => [C("span", null, _(t.askCompleteTime ? v(fe)(t.askCompleteTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 });
  };
} };
export {
  Se as default
};
