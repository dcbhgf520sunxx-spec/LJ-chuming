import { ref as r } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as F } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as P } from "vue";
import { unref as l } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElNotification as K } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElSwitch as O } from "element-plus";
import { ElPagination as q } from "element-plus";
import { vLoading as W } from "element-plus";
import { l as V, n as y, o as Y, J, G as b } from "../../../../shared/runtime.js";
import { x as T } from "../../../../modules/ship-manage-3066b2ed.js";
function $(c) {
  return V({ url: "/api/app/material/page", method: "get", params: c });
}
function j(c) {
  return V({ url: "/api/app/material/status", method: "put", params: c });
}
const Q = { class: "app-container" }, X = { class: "head-container" }, ae = { __name: "index", setup(c) {
  const t = { TRUE: { L: "启用", K: "TRUE", V: 1 }, FALSE: { L: "停用", K: "FALSE", V: 0 } };
  y(t);
  const g = { LAST_THREE_DAYS: { L: "查询最近三天的过磅记录（车牌/净重/毛重）", K: "LAST_THREE_DAYS", V: 1 }, LAST_RECORD: { L: "查询最近一次的过磅记录（车牌/净重/毛重）", K: "LAST_RECORD", V: 2 }, CURRENT_WEIGHT: { L: "查询当前磅重（仅重量）", K: "CURRENT_WEIGHT", V: 4 } };
  y(g);
  const u = r(), k = r(), p = r(false), _ = r([]), C = r([["updateTime", "parse-time"]]), { maxHeight: S } = Y({ paginate: true }), { handleSizeChange: L, handleCurrentChange: R, total: N, setTotalPage: x, queryPage: d } = J({ fetchHook: m });
  m();
  async function m() {
    if (b(T.get)) try {
      p.value = true;
      const { records: a = [], total: s } = await $({ status: u.value, pageNum: d.pageNumber, pageSize: d.pageSize });
      x(s), _.value = a.map((i) => (i.status = i.status ? t.TRUE.V : t.FALSE.V, i));
    } catch (a) {
      console.log(a);
    } finally {
      p.value = false;
    }
  }
  async function U(a, s) {
    try {
      await I.confirm('此操作将 "' + a.deviceName + '" 的状态修改为 "' + t.VL[a.status] + '", 是否继续？', "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await j({ id: a.id, status: s }), m(), K({ title: "状态修改成功", type: "success", duration: 3e3 });
    } catch (i) {
      console.log("变更状态", i), a.status = a.status === t.TRUE.V ? t.FALSE.V : t.TRUE.V;
    }
  }
  return (a, s) => {
    const i = v("common-radio-button"), o = G, A = O, M = v("common-table"), z = q, B = W;
    return w(), D("div", Q, [E("div", X, [e(i, { modelValue: u.value, "onUpdate:modelValue": s[0] || (s[0] = (n) => u.value = n), options: t.ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: m }, null, 8, ["modelValue", "options"])]), H((w(), F(M, { ref_key: "tableRef", ref: k, "data-format": C.value, data: _.value, "max-height": l(S), style: { width: "100%" } }, { default: h(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { key: "factoryName", align: "center", label: "工厂", "min-width": "130", prop: "factoryName", "show-overflow-tooltip": "" }), e(o, { key: "workshopName", align: "center", label: "车间", "min-width": "130", prop: "workshopName", "show-overflow-tooltip": "" }), e(o, { key: "deviceName", align: "center", label: "地磅名称", "min-width": "130", prop: "deviceName", "show-overflow-tooltip": "" }), e(o, { key: "deviceId", align: "center", label: "设备管理系统MID", "min-width": "130", prop: "deviceId", "show-overflow-tooltip": "" }), e(o, { key: "dockingMethod", align: "center", label: "三方地磅对接模式", "min-width": "230", prop: "dockingMethod", "show-overflow-tooltip": "" }, { default: h(({ row: n }) => [E("span", null, P(n.dockingMethod ? g.VL[n.dockingMethod] : "无"), 1)]), _: 1 }), e(o, { key: "status", prop: "status", label: "状态", align: "center", width: "90" }, { default: h(({ row: { sourceRow: n } }) => [e(A, { modelValue: n.status, "onUpdate:modelValue": (f) => n.status = f, disabled: !l(b)(l(T).editStatus), "active-color": "#13ce66", "active-value": t.TRUE.V, "inactive-value": t.FALSE.V, onChange: (f) => U(n, n.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 }), e(o, { key: "lastEditorUserName", align: "center", label: "最近编辑人", width: "150", prop: "lastEditorUserName", "show-overflow-tooltip": "" }), e(o, { key: "userName", align: "center", label: "创建人", width: "150", prop: "userName", "show-overflow-tooltip": "" }), e(o, { key: "updateTime", align: "center", label: "最近编辑时间", width: "170", prop: "updateTime", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[B, p.value]]), e(z, { total: l(N), "current-page": l(d).pageNumber, "page-size": l(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(L), onCurrentChange: l(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} };
export {
  ae as default
};
