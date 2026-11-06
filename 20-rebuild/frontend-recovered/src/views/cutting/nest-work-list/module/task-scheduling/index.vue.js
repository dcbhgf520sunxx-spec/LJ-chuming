import { ref as r } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as J } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as K } from "vue";
import { createElementVNode as l } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as W } from "vue";
import { toDisplayString as u } from "vue";
import { normalizeStyle as X } from "vue";
import { unref as d } from "vue";
import { isRef as Y } from "vue";
import { Fragment as Z } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { g as oe, a as ne } from "../../../../../modules/project-data-5e9d497a.js";
import { _ as ie, u as se, o as re } from "../../../../../shared/runtime.js";
import { b as ue } from "../../../../../modules/machine-10301ee2.js";
import ce from "../machie/index.vue.js";
import de from "../preview/index.vue.js";
const pe = { class: "el-drawer-container" }, me = { class: "table-content" }, fe = { __name: "index", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] }, detailData: { type: Object, required: true } }, emits: ["update:visible", "success"], setup(I, { emit: S }) {
  const D = S, f = I, H = r(), b = r(), g = r(), w = r(), y = r([]), k = r([]), c = r([]), p = r(false), x = r([]), { visible: v, handleClose: V } = se({ emit: D, props: f, field: "visible", closeHook: z, showHook: L }), { maxHeight: B } = re({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body", ".el-drawer-container"], navbar: false, extraHeight: 20, clientHRepMainH: true }, b), n = { size: 20, page: 1, total: null }, h = r(false), R = $(() => c.value && c.value.length > 0 && w.value);
  function L() {
    f.detailData && (m(), E());
  }
  function z() {
    n.size = 20, n.page = 1;
  }
  async function m() {
    h.value = true;
    try {
      const t = await oe({ projectId: f.detailData.projectId, pageSize: n.size, pageNumber: n.page });
      n.total = t.totalElements, y.value = t.content.filter((a) => !a.mac);
    } catch (t) {
      console.log("钢板清单页面接口报错", t);
    }
    h.value = false;
  }
  async function E() {
    const { content: t } = await ne();
    k.value = t;
  }
  function j() {
    p.value = true;
  }
  function M(t) {
    g.value = t, w.value = t.id;
  }
  function N(t) {
    c.value = t;
  }
  async function U() {
    try {
      x.value = c.value.map((a) => a.id);
      const t = await ue({ mac: g.value.mac }, x.value);
      ee({ message: t, type: "success" }), p.value = false, m();
    } catch (t) {
      console.log(t);
    }
  }
  function T(t) {
    n.size = t, m();
  }
  function q(t) {
    n.page = t, m();
  }
  return (t, a) => {
    const A = _("common-button"), s = te, F = _("common-table"), P = ae, G = _("common-drawer"), O = le;
    return C(), J(Z, null, [o(G, { ref_key: "drawerRef", ref: b, title: "任务排产", modelValue: d(v), "onUpdate:modelValue": a[3] || (a[3] = (e) => Y(v) ? v.value = e : null), direction: "btt", "before-close": d(V), "wrapper-closable": false, size: "95%" }, { titleRight: i(() => [o(A, { disabled: !R.value, type: "primary", size: "default", onClick: j }, { default: i(() => a[5] || (a[5] = [K("预览")])), _: 1, __: [5] }, 8, ["disabled"])]), content: i(() => [l("div", pe, [l("div", me, [Q((C(), W(F, { "max-height": 730, ref_key: "tableRef", ref: H, data: y.value, "row-key": "id", "empty-text": "暂无数据", onSelectionChange: N }, { default: i(() => [o(s, { fixed: "", type: "selection", width: "55", align: "center" }), o(s, { fixed: "", label: "序号", type: "index", align: "center", width: "60" }), o(s, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "指令号", "min-width": "100" }, { default: i((e) => [l("span", null, u(e.row.cutInstructionId), 1)]), _: 1 }), o(s, { align: "center", key: "num", prop: "num", "show-overflow-tooltip": true, label: "数量", "min-width": "30" }, { default: i((e) => [l("span", null, u(e.row.num), 1)]), _: 1 }), o(s, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "40" }, { default: i((e) => [l("span", null, u(e.row.material), 1)]), _: 1 }), o(s, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "40" }, { default: i((e) => [l("span", null, u(e.row.thick), 1)]), _: 1 }), o(s, { key: "width", prop: "width", "show-overflow-tooltip": true, label: "宽度（mm）", "min-width": "40" }, { default: i((e) => [l("span", null, u(e.row.width), 1)]), _: 1 }), o(s, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "40" }, { default: i((e) => [l("span", null, u(e.row.length), 1)]), _: 1 }), o(s, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "40" }, { default: i((e) => [l("span", null, u(e.row.weight), 1)]), _: 1 }), o(s, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "40" }, { default: i((e) => [l("span", null, u(e.row.weight), 1)]), _: 1 })]), _: 1 }, 8, ["data"])), [[O, h.value]]), o(P, { "page-size": n.size, "onUpdate:pageSize": a[0] || (a[0] = (e) => n.size = e), "current-page": n.page, "onUpdate:currentPage": a[1] || (a[1] = (e) => n.page = e), total: n.total, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a[2] || (a[2] = (e) => T(e)), onCurrentChange: q }, null, 8, ["page-size", "current-page", "total"])]), l("div", { class: "line-content", style: X({ "max-height": `${d(B)}px` }) }, [a[6] || (a[6] = l("div", { class: "tip" }, [l("span", null, "* 注意："), l("div", null, [l("span", { style: { display: "block" } }, "1. 构件未被禁止操作，构件任务未暂停，构件未处于报废或二次利用状态。"), l("span", { style: { display: "block" } }, "2. 只能选择一条生产线，所勾选构件的未分配数量会全部分配给该生产线。")])], -1)), o(d(ce), { machineData: k.value, selectLineId: w.value, onChange: M, isSingle: "" }, null, 8, ["machineData", "selectLineId"])], 4)])]), _: 1 }, 8, ["modelValue", "before-close"]), o(d(de), { onCloseHook: z, onTaskIssue: U, "detail-data": c.value, "select-line": g.value, visible: p.value, "onUpdate:visible": a[4] || (a[4] = (e) => p.value = e) }, null, 8, ["detail-data", "select-line", "visible"])], 64);
  };
} }, ye = ie(fe, [["__scopeId", "data-v-99f38de4"]]);
export {
  ye as default
};
