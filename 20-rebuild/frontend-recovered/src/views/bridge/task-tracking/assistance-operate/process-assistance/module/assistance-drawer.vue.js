import { ref as _ } from "vue";
import { inject as J } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as be } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as i } from "vue";
import { unref as o } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as F } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as u } from "vue";
import { withKeys as X } from "vue";
import { withModifiers as Y } from "vue";
import { isRef as we } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElMessageBox as _e } from "element-plus";
import { ElNotification as he } from "element-plus";
import { ElTag as ve } from "element-plus";
import { ElInput as ke } from "element-plus";
import { ElTableColumn as Te } from "element-plus";
import { ElCascader as Ie } from "element-plus";
import { vLoading as Ce } from "element-plus";
import { d as Ee, _ as Ve, a as xe } from "./assistance-preview.vue.js";
import { _ as Me, u as qe, o as Ne, ce as y, aw as Ae } from "../../../../../../shared/runtime.js";
import { m as ee } from "../../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import "../../../../../../modules/box-3fab54f9.js";
const Re = { class: "head-container" }, He = { __name: "assistance-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(I, { emit: te }) {
  const G = _(), ae = te, b = I, { visible: P, handleClose: oe } = qe({ emit: ae, props: b, field: "visible", showHook: Q }), { maxHeight: le } = Ne({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, G), ne = _([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), w = J("crud"), K = J("permission"), v = _({}), U = _([]), z = _(false), C = _({}), E = _([]), W = _([]), j = _(false), se = { groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }] }, ie = /* @__PURE__ */ new Map([["groupsId", "同上"]]), { tableValidate: re, cleanUpData: ue, wrongCellMask: pe } = Ae({ rules: se, ditto: ie });
  function de(r, t) {
    return !r.isComplete;
  }
  function Q() {
    v.value = {}, k();
  }
  function ce(r) {
    E.value = r;
  }
  function me(r, t, p) {
    p !== 0 && !r && (t.groupsId = "同上");
  }
  async function k() {
    var r, t, p, g, m, n, N, A, R, V, H, x, M, e, s, l, q, $;
    try {
      z.value = true, U.value = [], C.value = {};
      const { content: B } = await Ee({ taskOrderId: (r = b.info) == null ? void 0 : r.taskOrderId, taskTypeEnum: (t = b.info) == null ? void 0 : t.taskTypeEnum, processId: (p = b.info) == null ? void 0 : p.process.id, ...v.value });
      for (let L = 0; L < B.length; L++) {
        const a = B[L];
        if (a.attributeType = a.taskTypeEnum === y.CELL.V ? "单元件" : "套料", a.areaName = (g = a.area) == null ? void 0 : g.name, a.configId = (m = a.config) == null ? void 0 : m.id, a.groupsId = (n = a.groups) == null ? void 0 : n.id, a.isComplete = !!((N = a.totalCompleteMete) != null && N.quantity && ((A = a.totalTaskMete) != null && A.quantity) && ((R = a.totalCompleteMete) == null ? void 0 : R.quantity) === ((V = a.totalTaskMete) == null ? void 0 : V.quantity)), !C.value[a.configId]) {
          let S = {};
          w.query.taskTypeEnum === y.MACHINE_PART.V ? S = await ee({ productType: (H = b.info) == null ? void 0 : H.taskTypeEnum, disabledIds: ((x = a == null ? void 0 : a.groups) == null ? void 0 : x.id) && [(M = a == null ? void 0 : a.groups) == null ? void 0 : M.id] || [] }) : S = await ee({ productType: (e = b.info) == null ? void 0 : e.taskTypeEnum, boxClassId: a.configId, disabledIds: ((l = (s = b.info) == null ? void 0 : s.groups) == null ? void 0 : l.id) && [($ = (q = b.info) == null ? void 0 : q.groups) == null ? void 0 : $.id] || [], _factoryIds: a.factoryId && [a.factoryId] || [] }), C.value[a.configId] = S;
        }
        L > 0 && !a.groupsId && (a.groupsId = "同上"), U.value.push(a);
      }
    } catch (B) {
      console.log("可变更的任务工单详情列表获取失败", B);
    } finally {
      z.value = false;
    }
  }
  function fe() {
    var g;
    if (!((g = E.value) != null && g.length)) {
      Z.warning("请至少选择一条数据");
      return;
    }
    const r = E.value.map((m) => m), { validResult: t, dealList: p } = re(r);
    if (t) ue(p), W.value = p.map((m, n) => ({ ...m, assistance: { ...C.value[m.configId].obj[m.groupsId] } }));
    else return t;
    j.value = true;
  }
  function ge() {
    var r;
    if (!((r = E.value) != null && r.length)) {
      Z.warning("请至少选择一条数据");
      return;
    }
    _e.confirm("是否确认删除所选择的班组协同？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        const t = E.value.map((p) => p.id);
        await xe({ ids: t }), he({ title: "班组删除成功", type: "success" }), k();
      } catch (t) {
        console.log("班组删除失败", t);
      }
    });
  }
  function ye() {
    k();
  }
  return (r, t) => {
    var x, M;
    const p = ve, g = O("common-button"), m = ke, n = Te, N = Ie, A = O("common-table"), R = O("common-drawer"), V = be("permission"), H = Ce;
    return d(), c(R, { ref_key: "drawerRef", ref: G, title: `工序协同【${(M = (x = b.info) == null ? void 0 : x.process) == null ? void 0 : M.name}】`, modelValue: o(P), "onUpdate:modelValue": t[3] || (t[3] = (e) => we(P) ? P.value = e : null), direction: "rtl", "before-close": o(oe), size: "80%" }, { titleAfter: i(() => [o(w).query.taskTypeEnum !== o(y).MACHINE_PART.V ? (d(), c(p, { key: 0, effect: "plain" }, { default: i(() => {
      var e, s, l;
      return [T(" 原生产组：" + f((e = I.info.workshop) == null ? void 0 : e.name) + ">" + f((s = I.info.productionLine) == null ? void 0 : s.name) + ">" + f((l = I.info.groups) == null ? void 0 : l.name), 1)];
    }), _: 1 })) : h("", true)]), titleRight: i(() => [F((d(), c(g, { size: "default", type: "danger", onClick: ge }, { default: i(() => t[4] || (t[4] = [T("批量删除【协同班组】")])), _: 1, __: [4] })), [[V, o(K).del]]), F((d(), c(g, { size: "default", type: "primary", onClick: fe }, { default: i(() => t[5] || (t[5] = [T("预览并保存")])), _: 1, __: [5] })), [[V, o(K).save]])]), content: i(() => [D("div", Re, [u(m, { modelValue: v.value.serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (e) => v.value.serialNumber = e), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: X(k, ["enter"]) }, null, 8, ["modelValue"]), u(m, { modelValue: v.value.specification, "onUpdate:modelValue": t[1] || (t[1] = (e) => v.value.specification = e), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: X(k, ["enter"]) }, null, 8, ["modelValue"]), u(g, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: Y(k, ["stop"]) }, { default: i(() => t[6] || (t[6] = [T("搜索")])), _: 1, __: [6] }), u(g, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: Y(Q, ["stop"]) }, { default: i(() => t[7] || (t[7] = [T(" 重置 ")])), _: 1, __: [7] })]), F((d(), c(A, { data: U.value, "max-height": o(le), "cell-class-name": o(pe), "data-format": ne.value, onSelectionChange: ce, style: { width: "100%" } }, { default: i(() => [u(n, { type: "selection", width: "55", align: "center", selectable: de }), u(n, { label: "序号", type: "index", align: "center", width: "60" }), o(w).query.taskTypeEnum !== o(y).MACHINE_PART.V ? (d(), c(n, { key: 0, prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : h("", true), o(w).query.taskTypeEnum === o(y).MACHINE_PART.V ? (d(), c(n, { key: 1, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : h("", true), o(w).query.taskTypeEnum === o(y).CELL.V ? (d(), c(n, { key: 2, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: i(({ row: e }) => [u(p, { type: e.attributeType === "单元件" ? "warning" : "success" }, { default: i(() => [T(f(e.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : h("", true), o(w).query.taskTypeEnum !== o(y).MACHINE_PART.V ? (d(), c(n, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : h("", true), u(n, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), o(w).query.taskTypeEnum !== o(y).MACHINE_PART.V ? (d(), c(n, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : h("", true), u(n, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: i(({ row: e }) => {
      var s, l;
      return [D("span", null, f(((s = e.totalTaskMete) == null ? void 0 : s.quantity) || 0) + "/" + f(((l = e.totalTaskMete) == null ? void 0 : l.netWeight) || 0), 1)];
    }), _: 1 }), u(n, { align: "center", prop: "totalCompleteMete.quantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: i(({ row: e }) => {
      var s, l;
      return [D("span", null, f(((s = e.totalCompleteMete) == null ? void 0 : s.quantity) || 0) + "/" + f(((l = e.totalCompleteMete) == null ? void 0 : l.netWeight) || 0), 1)];
    }), _: 1 }), o(w).query.taskTypeEnum === o(y).MACHINE_PART.V ? (d(), c(n, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : h("", true), o(w).query.taskTypeEnum === o(y).MACHINE_PART.V ? (d(), c(n, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "180px" }, { default: i(({ row: e }) => {
      var s, l, q;
      return [D("span", null, f((s = e.workshop) == null ? void 0 : s.name) + ">" + f((l = e.productionLine) == null ? void 0 : l.name) + ">" + f((q = e.groups) == null ? void 0 : q.name), 1)];
    }), _: 1 })) : h("", true), u(n, { "show-overflow-tooltip": true, prop: "groupsId", label: "协同生产组", "min-width": "150px", align: "center" }, { default: i(({ row: { sourceRow: e }, $index: s }) => [u(N, { modelValue: e.groupsId, "onUpdate:modelValue": (l) => e.groupsId = l, options: C.value[e.configId].list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", disabled: e.isComplete, filterable: "", clearable: "", placeholder: s === 0 ? "请选择生产组" : "同上", style: { width: "100%" }, onChange: (l) => me(l, e, s) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "placeholder", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name", "data-format"])), [[H, z.value]]), u(o(Ve), { visible: j.value, "onUpdate:visible": t[2] || (t[2] = (e) => j.value = e), info: I.info, list: W.value, onSuccess: ye }, null, 8, ["visible", "info", "list"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ze = Me(He, [["__scopeId", "data-v-09cb7f91"]]);
export {
  ze as default
};
