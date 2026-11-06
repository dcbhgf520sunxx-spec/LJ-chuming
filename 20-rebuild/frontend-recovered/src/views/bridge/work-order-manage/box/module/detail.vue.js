import { inject as ae } from "vue";
import { ref as g } from "vue";
import { computed as oe } from "vue";
import { watch as ne } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as C } from "vue";
import { createBlock as D } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as d } from "vue";
import { createElementVNode as b } from "vue";
import { withDirectives as re } from "vue";
import { unref as r } from "vue";
import { createCommentVNode as H } from "vue";
import { isRef as ie } from "vue";
import { ElLoading as se } from "element-plus";
import { ElMessage as ce } from "element-plus";
import { ElNotification as pe } from "element-plus";
import { ElTag as ue } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElPagination as me } from "element-plus";
import { l as v, _ as fe, u as ge, J as ye, F as u, n as _e, o as he, p as U, ci as we, cj as be, ck as R, $ as W, cl as ve, bg as Te } from "../../../../../shared/runtime.js";
function ke(c) {
  return v({ module: "bridge", url: "task/order/box/page", method: "get", params: c });
}
function Le(c) {
  return v({ module: "bridge", url: "task/process/list", method: "get", params: c });
}
function Se(c) {
  return v({ module: "bridge", url: "task/process/product/task/list/page", method: "get", params: c });
}
function xe(c) {
  return v({ module: "bridge", url: "task/process/nesting/task/list/page", method: "get", params: c });
}
function Ve(c) {
  return v({ module: "bridge", url: "task/process/task/list/sign", method: "get", params: c });
}
const Oe = { get: ke };
const Ee = { class: "head-container" }, Ce = { style: { float: "right" } }, De = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(c, { emit: F }) {
  const G = ae("permission"), O = g(), z = F, n = c, { visible: T, handleClose: X } = ge({ emit: z, props: n, field: "visible" }), { handleSizeChange: $, handleCurrentChange: Q, total: J, setTotalPage: A, queryPage: k } = ye({ fetchHook: Z }), p = { TASK_LIST: { L: "任务清单", K: "TASK_LIST", V: 1, [u.BOX.K]: "bridgeProductionTaskOrder", [u.CELL.K]: "bridgeAssembleProductionTaskOrder" }, NESTING_LIST: { L: "套料清单", K: "NESTING_LIST", V: 2, [u.CELL.K]: "bridgeAssembleNestingOrder" } };
  _e(p);
  const { maxHeight: j } = he({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, O), L = g([]), B = g([]), S = g(), m = g(p.TASK_LIST.V), f = oe(() => ({ orderId: n.detailData.orderId, processId: S.value, productType: n.detailData.productType, projectId: n.detailData.projectId }));
  ne(() => T.value, (i) => {
    i && (m.value = p.TASK_LIST.V, S.value = void 0, Y());
  }, { deep: true, immediate: true });
  async function Y() {
    var i;
    try {
      const e = await Le({ orderId: n.detailData.orderId, productionLineId: (i = n.detailData.productionLine) == null ? void 0 : i.id });
      B.value = e, P();
    } catch (e) {
      console.log("获取工序", e);
    }
  }
  async function M() {
    var e;
    let i = [];
    try {
      const l = n.detailData.productType === u.BOX.V ? { ...f.value, productionLineTypeEnum: (e = n.detailData.productionLine) == null ? void 0 : e.productionLineTypeEnum } : { ...f.value, type: m.value }, { content: h = [], totalElements: w } = await Se({ ...l, ...k });
      A(w), i = h;
    } catch (l) {
      console.log("获取生产任务单", l);
    } finally {
      L.value = i;
    }
  }
  async function q() {
    let i = [];
    try {
      const { content: e = [], totalElements: l } = await xe({ ...f.value, type: m.value, ...k });
      A(l), i = e;
    } catch (e) {
      console.log("获取单元件套料清单", e);
    } finally {
      L.value = i;
    }
  }
  function P(i) {
    m.value === p.TASK_LIST.V ? M() : q();
  }
  function Z() {
    m.value === p.TASK_LIST.V ? M() : q();
  }
  const _ = g();
  async function ee() {
    var i;
    _.value = se.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      for (const e in p.ENUM) {
        const l = p[e][u.VK[n.detailData.productType]];
        if (!l) continue;
        _.value.text = `正在加载数据：${p[e].L}`;
        const h = we[l], w = n.detailData.productType === u.BOX.V ? { ...f.value, productionLineTypeEnum: (i = n.detailData.productionLine) == null ? void 0 : i.productionLineTypeEnum } : { ...f.value, type: m.value };
        let o = await be[l](w) || {};
        R[l] && (o = await R[l](o));
        const { header: x, footer: I, table: N, qrCode: K } = o;
        _.value.text = `正在加入打印队列：${p[e].L}`, await W(500);
        const a = await ve({ printMode: Te.CUSTOM_QUEUE.V, header: x, footer: I, table: N, qrCode: K, config: h });
        if (typeof a == "object") {
          const { type: V, message: te } = a;
          return ce({ type: V, message: te });
        }
        if (!a) throw new Error("导出失败");
      }
      _.value.text = "已全部加入打印队列", await W(500);
    } catch (e) {
      throw pe({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(e);
    } finally {
      _.value.close(), await Ve({ ...f.value }), z("refresh");
    }
  }
  return (i, e) => {
    const l = ue, h = E("common-radio-button"), w = E("common-button"), o = de, x = E("common-table"), I = me, N = E("common-drawer"), K = le("permission");
    return C(), D(N, { ref_key: "drawerRef", ref: O, title: "生产任务单", modelValue: r(T), "onUpdate:modelValue": e[1] || (e[1] = (a) => ie(T) ? T.value = a : null), direction: "rtl", "before-close": r(X), size: "60%" }, { titleAfter: s(() => [t(l, null, { default: s(() => {
      var a;
      return [y("项目：" + d((a = n.detailData.project) == null ? void 0 : a.name), 1)];
    }), _: 1 }), t(l, null, { default: s(() => {
      var a, V;
      return [y("产线：" + d((a = n.detailData.workshop) == null ? void 0 : a.name) + ">" + d((V = n.detailData.productionLine) == null ? void 0 : V.name), 1)];
    }), _: 1 }), t(l, null, { default: s(() => [y("总量：" + d(n.detailData.taskQuantity) + "/" + d(n.detailData.taskMete), 1)]), _: 1 }), t(l, null, { default: s(() => [y("任务单号：" + d(n.detailData.scheduleOrder), 1)]), _: 1 })]), content: s(() => [b("div", Ee, [t(h, { modelValue: S.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => S.value = a), options: B.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", showOptionAll: "", class: "filter-item", onChange: P }, null, 8, ["modelValue", "options"]), b("div", Ce, [re((C(), D(w, { icon: "el-icon-printer", size: "default", type: "success", onClick: ee }, { default: s(() => e[2] || (e[2] = [y(" 打印【任务清单】 ")])), _: 1, __: [2] })), [[K, r(G).print]])])]), b("div", null, [n.detailData.productType === r(u).BOX.V ? (C(), D(x, { key: 0, ref: "table", data: L.value, "empty-text": "暂无数据", "max-height": r(j), style: { width: "100%" } }, { default: s(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { "show-overflow-tooltip": true, label: "单体", key: "monomer.name", prop: "monomer.name", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "区域", key: "area.name", prop: "area.name", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "编号", key: "serialNumber", prop: "serialNumber", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "规格", key: "specification", prop: "specification", align: "center", "min-width": "110px" }), t(o, { "show-overflow-tooltip": true, label: "长度（mm）", key: "length", prop: "length", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "单重（kg）", key: "netWeight", prop: "netWeight", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "任务数", key: "quantity", prop: "quantity", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "完成日期", key: "complete", prop: "completeTime", align: "center" }, { default: s((a) => [b("span", null, d(a.row.completeTime ? r(U)(a.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])) : H("", true), n.detailData.productType === r(u).CELL.V && m.value === p.TASK_LIST.V ? (C(), D(x, { key: 1, ref: "table", data: L.value, "empty-text": "暂无数据", "max-height": r(j), style: { width: "100%" } }, { default: s(() => [t(o, { "show-overflow-tooltip": true, label: "属性", key: "taskType", prop: "taskType", align: "center" }, { default: s((a) => [t(l, { type: a.row.taskType & r(u).CELL.V ? "" : "success", effect: "plain" }, { default: s(() => [y(d(r(u).VL[a.row.taskType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), t(o, { "show-overflow-tooltip": true, label: "编号", key: "serialNumber", prop: "serialNumber", align: "center", "min-width": "130px" }), t(o, { "show-overflow-tooltip": true, label: "规格", key: "specification", prop: "specification", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "长度（mm）", key: "length", prop: "length", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "数量", key: "quantity", prop: "quantity", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "单重", key: "netWeight", prop: "netWeight", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "完成日期", key: "complete", prop: "completeTime", align: "center" }, { default: s((a) => [b("span", null, d(a.row.completeTime ? r(U)(a.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])) : H("", true), t(I, { total: r(J), "current-page": r(k).pageNumber, "page-size": r(k).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r($), onCurrentChange: r(Q) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ie = fe(De, [["__scopeId", "data-v-adab11c8"]]), ze = Object.freeze(Object.defineProperty({ __proto__: null, default: Ie }, Symbol.toStringTag, { value: "Module" }));
export {
  ze as a,
  Oe as c,
  Ie as d
};
