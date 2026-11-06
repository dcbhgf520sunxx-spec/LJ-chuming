import { ref as r } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as J } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as K } from "vue";
import { createElementVNode as l } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as W } from "vue";
import { toDisplayString as c } from "vue";
import { normalizeStyle as X } from "vue";
import { unref as d } from "vue";
import { isRef as Y } from "vue";
import { Fragment as Z } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { g as ne, a as oe } from "../../../../../../modules/project-data-5e9d497a.js";
import { _ as ie, u as se, o as re } from "../../../../../../shared/runtime.js";
import { b as ce } from "../../../../../../modules/machine-10301ee2.js";
import ue from "../machie/index.vue.js";
import de from "../preview/index.vue.js";
const pe = { class: "el-drawer-container" }, me = { class: "table-content" }, ge = { __name: "index", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] }, detailData: { type: Object, required: true } }, emits: ["update:visible", "success"], setup(H, { emit: V }) {
  const y = V, p = H, g = r(), k = r(), f = r(), w = r(), x = r([]), z = r([]), u = r([]), m = r(false), C = r([]), { visible: v, handleClose: I } = se({ emit: y, props: p, field: "visible", closeHook: D, showHook: L }), { maxHeight: B } = re({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body", ".el-drawer-container"], navbar: false, extraHeight: 20, clientHRepMainH: true }, k), o = { size: 20, page: 1, total: null }, h = r(false), R = $(() => u.value && u.value.length > 0 && w.value);
  function L() {
    p.detailData && (_(), E()), g.value && g.value.clearSelection();
  }
  function D() {
    o.size = 20, o.page = 1;
  }
  async function _() {
    h.value = true;
    try {
      const t = await ne({ projectId: p.detailData.projectId, pageSize: o.size, pageNumber: o.page, plateID: p.detailData.id });
      o.total = t.totalElements, x.value = t.content.filter((a) => !a.mac);
    } catch (t) {
      console.log("钢板清单页面接口报错", t);
    }
    h.value = false;
  }
  async function E() {
    const { content: t } = await oe();
    z.value = t;
  }
  function j() {
    m.value = true;
  }
  function M(t) {
    f.value = t, w.value = t.id;
  }
  function N(t) {
    u.value = t;
  }
  async function U() {
    try {
      C.value = u.value.map((a) => a.id);
      const t = await ce({ mac: f.value.mac }, C.value);
      ee({ message: t, type: "success" }), m.value = false, y("success"), I();
    } catch (t) {
      console.log(t);
    }
  }
  function T(t) {
    o.size = t, _();
  }
  function q(t) {
    o.page = t, _();
  }
  return (t, a) => {
    const A = b("common-button"), s = te, F = b("common-table"), P = ae, G = b("common-drawer"), O = le;
    return S(), J(Z, null, [n(G, { ref_key: "drawerRef", ref: k, title: "任务排产", modelValue: d(v), "onUpdate:modelValue": a[3] || (a[3] = (e) => Y(v) ? v.value = e : null), direction: "btt", "before-close": d(I), "wrapper-closable": false, size: "95%" }, { titleRight: i(() => [n(A, { disabled: !R.value, type: "primary", size: "default", onClick: j }, { default: i(() => a[5] || (a[5] = [K("预览")])), _: 1, __: [5] }, 8, ["disabled"])]), content: i(() => [l("div", pe, [l("div", me, [Q((S(), W(F, { "max-height": 730, ref_key: "tableRef", ref: g, data: x.value, "row-key": "id", "empty-text": "暂无数据", onSelectionChange: N }, { default: i(() => [n(s, { fixed: "", type: "selection", width: "55", align: "center" }), n(s, { fixed: "", label: "序号", type: "index", align: "center", width: "60" }), n(s, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "指令号", "min-width": "100", align: "center" }, { default: i((e) => [l("span", null, c(e.row.cutInstructionId), 1)]), _: 1 }), n(s, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "40" }, { default: i((e) => [l("span", null, c(e.row.material), 1)]), _: 1 }), n(s, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "40", align: "center" }, { default: i((e) => [l("span", null, c(e.row.thick), 1)]), _: 1 }), n(s, { key: "width", prop: "width", "show-overflow-tooltip": true, label: "宽度（mm）", "min-width": "40", align: "center" }, { default: i((e) => [l("span", null, c(e.row.width), 1)]), _: 1 }), n(s, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "40", align: "center" }, { default: i((e) => [l("span", null, c(e.row.length), 1)]), _: 1 }), n(s, { align: "center", key: "num", prop: "num", "show-overflow-tooltip": true, label: "数量", "min-width": "30" }, { default: i((e) => [l("span", null, c(e.row.num), 1)]), _: 1 }), n(s, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "40", align: "center" }, { default: i((e) => [l("span", null, c(e.row.weight), 1)]), _: 1 }), n(s, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "40", align: "center" }, { default: i((e) => [l("span", null, c(e.row.weight), 1)]), _: 1 })]), _: 1 }, 8, ["data"])), [[O, h.value]]), n(P, { "page-size": o.size, "onUpdate:pageSize": a[0] || (a[0] = (e) => o.size = e), "current-page": o.page, "onUpdate:currentPage": a[1] || (a[1] = (e) => o.page = e), total: o.total, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a[2] || (a[2] = (e) => T(e)), onCurrentChange: q }, null, 8, ["page-size", "current-page", "total"])]), l("div", { class: "line-content", style: X({ "max-height": `${d(B)}px` }) }, [a[6] || (a[6] = l("div", { class: "tip" }, [l("span", null, "* 注意："), l("div", null, [l("span", { style: { display: "block" } }, "1. 构件未被禁止操作，构件任务未暂停，构件未处于报废或二次利用状态。"), l("span", { style: { display: "block" } }, "2. 只能选择一条生产线，所勾选构件的未分配数量会全部分配给该生产线。")])], -1)), n(d(ue), { machineData: z.value, selectLineId: w.value, onChange: M, isSingle: "" }, null, 8, ["machineData", "selectLineId"])], 4)])]), _: 1 }, 8, ["modelValue", "before-close"]), n(d(de), { onCloseHook: D, onTaskIssue: U, "detail-data": u.value, "select-line": f.value, visible: m.value, "onUpdate:visible": a[4] || (a[4] = (e) => m.value = e) }, null, 8, ["detail-data", "select-line", "visible"])], 64);
  };
} }, ye = ie(ge, [["__scopeId", "data-v-a186095d"]]);
export {
  ye as default
};
