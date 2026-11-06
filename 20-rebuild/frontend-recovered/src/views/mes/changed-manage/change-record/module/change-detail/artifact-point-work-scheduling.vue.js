import { ref as c } from "vue";
import { inject as _ } from "vue";
import { watchEffect as $ } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as B } from "vue";
import { createBlock as F } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as y } from "vue";
import { createTextVNode as M } from "vue";
import { unref as h } from "vue";
import C from "moment";
import { ElMessage as W } from "element-plus";
import { ElDivider as G } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElInputNumber as P } from "element-plus";
import { ElCascader as K } from "element-plus";
import { ElDatePicker as Y } from "element-plus";
import { Delete as J } from "@element-plus/icons-vue";
import { ElCard as X } from "element-plus";
import { m as Z } from "../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import { a3 as ee, V as k, aw as le } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
const se = { __name: "artifact-point-work-scheduling", setup(te) {
  const T = ee.ARTIFACT.V, g = c({}), m = c([]), f = c([]), w = c([]), V = _("schedulingInfo"), r = _("schedulingHandle"), I = { needSchedulingQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, S = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: x, cleanUpData: Q, wrongCellMask: E } = le({ rules: I, ditto: S });
  L(), $(() => {
    const n = [], o = [], s = k(V.value.pointWorkTaskArtifactList);
    for (let t = 0; t < s.length; t++) {
      const e = s[t];
      `${e.id}${e.areaId}`, r.value[e.id] ? n.push(e) : o.push(e);
    }
    f.value = n, w.value = o;
  });
  async function L() {
    g.value = await Z({ productType: T }, true);
  }
  function N(n, o, s) {
    s !== 0 && !n && (o.groupsId = "同上");
  }
  function R(n, o, s) {
    s !== 0 && !n && (o.askCompleteTime = "同上");
  }
  function U(n) {
    m.value = n;
  }
  function j() {
    if (!m.value.length) {
      W.warning("请至少选择一条数据");
      return;
    }
    const { validResult: n, dealList: o } = x(m.value);
    if (n) {
      const s = k(o);
      Q(s), s.forEach((t) => {
        const e = `${t.id}`, u = `${t.groupsId}_${t.askCompleteTime}`;
        r.value[e] ? r.value[e].handleObj[u] ? r.value[e].handleObj[u].needSchedulingQuantity = t.needSchedulingQuantity : r.value[e].handleObj[u] = { groupsId: t.groupsId, askCompleteTime: t.askCompleteTime, needSchedulingQuantity: t.needSchedulingQuantity } : r.value[e] = { ...t, handleObj: { [u]: { groupsId: t.groupsId, askCompleteTime: t.askCompleteTime, needSchedulingQuantity: t.needSchedulingQuantity } } };
      });
    }
  }
  function O(n) {
    r.value[n.id] && delete r.value[n.id];
  }
  return (n, o) => {
    const s = G, t = v("common-button"), e = H, u = P, D = K, A = Y, b = v("common-table"), q = J, z = X;
    return B(), F(z, null, { default: a(() => [l(s, null, { default: a(() => o[0] || (o[0] = [y("span", { class: "title", style: { padding: "5px 50px" } }, "构件点工任务列表", -1)])), _: 1, __: [0] }), l(t, { type: "success", size: "default", style: { "margin-bottom": "10px" }, onClick: j }, { default: a(() => o[1] || (o[1] = [M("加入下发列表")])), _: 1, __: [1] }), l(b, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: f.value, "cell-class-name": h(E), style: { width: "100%", "margin-bottom": "50px" }, onSelectionChange: U }, { default: a(() => [l(e, { type: "selection", align: "center", width: "60" }), l(e, { label: "序号", type: "index", align: "center", width: "60" }), l(e, { label: "区域", prop: "area.name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "名称", prop: "name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "原构件信息", align: "center" }, { default: a(() => [l(e, { label: "编号", prop: "oldSerialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" })]), _: 1 }), l(e, { label: "变更后构件信息", align: "center" }, { default: a(() => [l(e, { label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), l(e, { label: "材质", prop: "material", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "单净重（kg）", prop: "netWeight", "show-overflow-tooltip": "", align: "center", "min-width": "100" })]), _: 1 }), l(e, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: a(({ row: { sourceRow: i } }) => [l(u, { modelValue: i.needSchedulingQuantity, "onUpdate:modelValue": (p) => i.needSchedulingQuantity = p, step: 1, min: 0, max: i.originQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), l(e, { "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: a(({ row: { sourceRow: i }, $index: p }) => [l(D, { modelValue: i.groupsId, "onUpdate:modelValue": (d) => i.groupsId = d, options: g.value.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, filterable: "", clearable: "", style: { width: "100%" }, placeholder: p === 0 ? "请选择生产组" : "同上", onChange: (d) => N(d, i, p) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])]), _: 1 }), l(e, { prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "130px" }, { default: a(({ row: { sourceRow: i }, $index: p }) => [l(A, { modelValue: i.askCompleteTime, "onUpdate:modelValue": (d) => i.askCompleteTime = d, type: "date", size: "default", "value-format": "x", style: { width: "100%" }, disabledDate: (d) => h(C)(d).valueOf() < h(C)().subtract(1, "days").valueOf(), placeholder: p === 0 ? "需求完成日期" : "同上", onChange: (d) => R(d, i, p) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "placeholder", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), l(s, null, { default: a(() => o[2] || (o[2] = [y("span", { class: "title", style: { padding: "5px 50px" } }, "构件点工下发列表", -1)])), _: 1, __: [2] }), l(b, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: w.value, style: { width: "100%" } }, { default: a(() => [l(e, { width: "60" }, { default: a(({ row: i }) => [l(t, { type: "danger", size: "default", onClick: (p) => O(i) }, { default: a(() => [l(q)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), l(e, { label: "序号", type: "index", align: "center", width: "60" }), l(e, { label: "区域", prop: "area.name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "名称", prop: "name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "原构件信息", align: "center" }, { default: a(() => [l(e, { label: "编号", prop: "oldSerialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" })]), _: 1 }), l(e, { label: "变更后构件信息", align: "center" }, { default: a(() => [l(e, { label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), l(e, { label: "材质", prop: "material", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l(e, { label: "单净重（kg）", prop: "netWeight", "show-overflow-tooltip": "", align: "center", "min-width": "100" })]), _: 1 }), l(e, { label: "数量", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "90" })]), _: 1 }, 8, ["data"])]), _: 1 });
  };
} };
export {
  se as default
};
