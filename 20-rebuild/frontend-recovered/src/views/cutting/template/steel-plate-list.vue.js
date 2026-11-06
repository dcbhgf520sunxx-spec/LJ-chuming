import { ref as c } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as n } from "vue";
import { withCtx as l } from "vue";
import { unref as p } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as z } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as I } from "vue";
import { isRef as F } from "vue";
import { Fragment as G } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElPagination as O } from "element-plus";
import { vLoading as $ } from "element-plus";
import { _ as A, u as J, G as K } from "../../../shared/runtime.js";
import Q from "./detail.vue.js";
import { g as W } from "../../../modules/machine-10301ee2.js";
import { g as X } from "../../../modules/project-data-5e9d497a.js";
import { p as Y } from "../../../modules/cutting-457c256f.js";
const Z = { class: "flex-rss" }, ee = { key: 0 }, te = { __name: "steel-plate-list", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible"], setup(x, { emit: V }) {
  const m = x, a = { size: 20, page: 1, total: null }, f = c(false), D = V, { visible: g, handleClose: h } = J({ emit: D, props: m, field: "visible", closeHook: R, showHook: j }), b = c([]), _ = c(false), L = c(), y = c([]);
  function j() {
    m.detailData && w();
  }
  function R() {
    a.size = 20, a.page = 1;
  }
  async function w() {
    f.value = true;
    try {
      const e = await X({ projectId: m.detailData.projectId, pageSize: a.size, pageNumber: a.page });
      a.total = e.totalElements;
      for (var o = 0; o < e.content.length; o++) if (e.content[o].mac) {
        const s = await W(e.content[o].mac);
        e.content[o].machineType = s.machineType, e.content[o].factory = s.factory, e.content[o].workshopInf = s.workshopInf, e.content[o].productionLine = s.productionLine;
      }
      b.value = e.content;
    } catch (e) {
      console.log("钢板清单页面接口报错", e);
    }
    f.value = false;
  }
  function B(o) {
    y.value = o, _.value = true;
  }
  function N(o) {
    L.value = o.id;
  }
  function P(o) {
    a.size = o, w();
  }
  function S(o) {
    a.page = o, w();
  }
  return (o, e) => {
    const s = v("common-button"), r = M, T = v("common-table"), q = O, E = v("common-dialog"), H = $;
    return d(), k(G, null, [n(E, { title: "钢板切割状态", width: "70%", "show-close": false, "close-on-click-modal": false, modelValue: p(g), "onUpdate:modelValue": e[3] || (e[3] = (t) => F(g) ? g.value = t : null), "before-close": p(h) }, { titleRight: l(() => [n(s, { size: "default", onClick: p(h) }, { default: l(() => e[5] || (e[5] = [C("关 闭")])), _: 1, __: [5] }, 8, ["onClick"])]), default: l(() => [u("div", Z, [U((d(), z(T, { "row-key": "id", ref: "tableRef", "max-height": 500, style: { width: "100%" }, data: b.value }, { default: l(() => [n(r, { label: "序号", type: "index", align: "center", width: "60" }), n(r, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100", align: "center" }, { default: l((t) => [u("span", null, i(t.row.cutInstructionId), 1)]), _: 1 }), n(r, { align: "center", key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "55" }, { default: l((t) => [u("span", null, i(t.row.thick), 1)]), _: 1 }), n(r, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "40" }, { default: l((t) => [u("span", null, i(t.row.material), 1)]), _: 1 }), n(r, { key: "specification", align: "center", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "40" }, { default: l((t) => [u("span", null, i(t.row.width) + " * " + i(t.row.length), 1)]), _: 1 }), n(r, { key: "equipment", prop: "equipment", "show-overflow-tooltip": true, label: "产线设备", "min-width": "100", align: "center" }, { default: l((t) => [t.row.factory ? (d(), k("span", ee, i(t.row.factory) + ">" + i(t.row.workshopInf) + ">" + i(t.row.productionLine), 1)) : I("", true)]), _: 1 }), n(r, { align: "center", "show-overflow-tooltip": true, label: "套料成果", "min-width": "70" }, { default: l((t) => [p(K)(p(Y).detailResult) ? (d(), z(s, { key: 0, type: "success", size: "default", onClick: (oe) => B(t.row) }, { default: l(() => e[6] || (e[6] = [C("查看")])), _: 2, __: [6] }, 1032, ["onClick"])) : I("", true)]), _: 1 })]), _: 1 }, 8, ["data"])), [[H, f.value]])]), n(q, { "page-size": a.size, "onUpdate:pageSize": e[0] || (e[0] = (t) => a.size = t), "current-page": a.page, "onUpdate:currentPage": e[1] || (e[1] = (t) => a.page = t), total: a.total, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e[2] || (e[2] = (t) => P(t)), onCurrentChange: S }, null, 8, ["page-size", "current-page", "total"])]), _: 1 }, 8, ["modelValue", "before-close"]), n(Q, { onChange: N, "detail-data": y.value, visible: _.value, "onUpdate:visible": e[4] || (e[4] = (t) => _.value = t) }, null, 8, ["detail-data", "visible"])], 64);
  };
} }, ce = A(te, [["__scopeId", "data-v-060878e3"]]);
export {
  ce as default
};
