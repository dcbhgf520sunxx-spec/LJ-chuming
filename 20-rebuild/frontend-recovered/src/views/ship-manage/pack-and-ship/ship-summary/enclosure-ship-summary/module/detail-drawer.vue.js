import { ref as D } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as v } from "vue";
import { createBlock as N } from "vue";
import { withCtx as m } from "vue";
import { withDirectives as j } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as O } from "vue";
import { createElementVNode as k } from "vue";
import { toDisplayString as C } from "vue";
import { isRef as Q } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElPagination as U } from "element-plus";
import { vLoading as J } from "element-plus";
import { i as $ } from "../../../../../../modules/enclosure-ship-summary-6941ca85.js";
import { u as A, J as F, o as G, c as L, D as S } from "../../../../../../shared/runtime.js";
import { o as K } from "../../../../../../modules/ship-manage-3066b2ed.js";
const ee = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(g, { emit: I }) {
  const x = I, w = D([]), h = D(false), i = g, { visible: y, handleClose: q } = A({ emit: x, props: i, field: "visible", showHook: E }), { handleSizeChange: z, handleCurrentChange: M, total: R, setTotalPage: V, queryPage: b } = F({ fetchHook: E }), { maxHeight: B } = G({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, y);
  async function E() {
    w.value = [], h.value = true;
    try {
      const { content: u = [], totalElements: c } = await $({ projectId: i.projectId, ...i.query, workshopId: i.workshopId, ...b });
      w.value = u, V(c), h.value = false;
    } catch (u) {
      console.log("获取详情失败", u), h.value = false;
    }
  }
  function P(u) {
    const { columns: c, data: f } = u, e = [];
    return c.forEach((r, l) => {
      if (l === 0) {
        e[l] = "合计";
        return;
      }
      if (r.property === "quantity" || r.property === "inboundQuantity" || r.property === "cargoQuantity") {
        const s = f.map((t) => Number(t[r.property]));
        s.every((t) => isNaN(t)) || (e[l] = s.reduce((t, p) => {
          const n = Number(p);
          return isNaN(n) ? t : t + p;
        }, 0));
      }
      if (r.property === "cargoTotalLength") {
        const s = f.map((t) => Number(t[r.property]));
        s.every((t) => isNaN(t)) || (e[l] = s.reduce((t, p) => {
          const n = Number(p);
          return isNaN(n) ? t : t + p;
        }, 0), e[l] = L(e[l], "mm", "m", S.MES_ENCLOSURE_L__M));
      }
    }), e;
  }
  return (u, c) => {
    const f = _("print-table"), e = T, r = _("common-table"), l = U, s = _("common-drawer"), t = H("permission"), p = J;
    return v(), N(s, { ref: "drawerRef", "custom-class": "detail-drawer", title: `项目:${g.detailData.project.serialNumber + " " + g.detailData.project.shortName}`, modelValue: o(y), "onUpdate:modelValue": c[0] || (c[0] = (n) => Q(y) ? y.value = n : null), direction: "rtl", "before-close": o(q), size: "70%" }, { titleRight: m(() => [j(a(f, { "api-key": "enclosureProjectShipDetail", params: { projectId: i.projectId, workshopId: i.workshopId, ...i.query }, size: "default", type: "warning" }, null, 8, ["params"]), [[t, o(K).print]])]), content: m(() => [j((v(), N(r, { data: w.value, "show-summary": "", "summary-method": P, "max-height": o(B) - 70 }, { default: m(() => {
      var n;
      return [a(e, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), a(e, { key: "areaName", prop: "areaName", label: "批次", align: "center", "show-overflow-tooltip": true }), a(e, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), a(e, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), ((n = g.query) == null ? void 0 : n.category) !== 32 ? (v(), N(e, { key: "plate", prop: "plate", label: "板型", align: "center", "show-overflow-tooltip": true })) : O("", true), a(e, { key: "length", prop: "length", label: "单长(mm)", align: "center", "show-overflow-tooltip": true }, { default: m((d) => [k("span", null, C(d.row.length), 1)]), _: 1 }), a(e, { key: "totalLength", prop: "totalLength", label: "总长(m)", align: "center", "show-overflow-tooltip": true }, { default: m((d) => [k("span", null, C(o(L)(d.row.totalLength, "mm", "m", o(S).MES_ENCLOSURE_L__M)), 1)]), _: 1 }), a(e, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": true }), a(e, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": true }), a(e, { key: "cargoQuantity", prop: "cargoQuantity", label: "发运数", align: "center", "show-overflow-tooltip": true }), a(e, { key: "cargoTotalLength", prop: "cargoTotalLength", label: "发运总长(m)", align: "center", "show-overflow-tooltip": true }, { default: m((d) => [k("span", null, C(o(L)(d.row.cargoTotalLength, "mm", "m", o(S).MES_ENCLOSURE_L__M)), 1)]), _: 1 }), a(e, { key: "remark", prop: "remark", label: "备注", align: "center", "min-width": "120", "show-overflow-tooltip": true })];
    }), _: 1 }, 8, ["data", "max-height"])), [[p, h.value]]), a(l, { total: o(R), "current-page": o(b).pageNumber, "page-size": o(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(z), onCurrentChange: o(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ee as default
};
