import { ref as f } from "vue";
import { watch as C } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as B } from "vue";
import { withDirectives as v } from "vue";
import { vShow as h } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as i } from "vue";
import { unref as c } from "vue";
import { createBlock as L } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as E } from "vue";
import { ElTableColumn as O } from "element-plus";
import { g as S, _ as T } from "../list-detail/index.vue.js";
import { _ as q, o as A, p as I, br as M, nm as y, G as P, nu as Q } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/SingleFileUploadBtn-17bec156.js";
const W = { class: "app-container" }, H = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(N) {
  const p = N, { maxHeight: x } = A({ paginate: true }), u = f(false), w = f({}), d = f([]);
  C(() => p.projectData.id, (o) => {
    o && j();
  });
  async function j() {
    if (!p.projectData.id) return;
    const o = [];
    try {
      const { content: t } = await S({ projectId: p.projectData.id });
      console.log(t, "content"), t == null || t.map((a) => {
        var r;
        (r = a.assembleBatchAreaDOList) != null && r.length && a.assembleBatchAreaDOList.map((m, e) => {
          var _;
          o.push({ monomerName: a.name, areaName: m.name, ...m, rowspan: e === 0 ? (_ = a.assembleBatchAreaDOList) == null ? void 0 : _.length : 0 });
        });
      }), d.value = o, console.log(d.value);
    } catch (t) {
      console.log("获取项目套料进度详情失败", t);
    }
  }
  function D(o) {
    console.log(o, "row"), u.value = true, w.value = o;
  }
  function k({ row: o, column: t, rowIndex: a, columnIndex: r }) {
    if (r === 0) return { rowspan: o.rowspan || 0, colspan: 1 };
  }
  return (o, t) => {
    const a = O, r = g("common-button"), m = g("common-table");
    return b(), B("div", W, [v(l("div", null, t[1] || (t[1] = [l("div", { class: "my-code" }, "*点击左侧项目行查看详情", -1)]), 512), [[h, !p.projectData.id]]), v(l("div", null, [n(m, { ref: "tableRef", data: d.value, "empty-text": "暂无数据", "max-height": c(x), "row-key": "id", style: { width: "100%" }, "span-method": k }, { default: s(() => [n(a, { align: "center", key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体" }, { default: s((e) => [l("span", null, i(e.row.monomerName), 1)]), _: 1 }), n(a, { align: "center", key: "areaName", prop: "areaName", "show-overflow-tooltip": true, label: "区域" }, { default: s((e) => [l("span", null, i(e.row.areaName), 1)]), _: 1 }), n(a, { align: "center", key: "date", prop: "date", "show-overflow-tooltip": true, label: "完成日期" }, { default: s((e) => [l("span", null, i(c(I)(e.row.date, "{y}-{m}-{d}")), 1)]), _: 1 }), n(a, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "部件数量" }, { default: s((e) => [l("span", null, i(e.row.quantity), 1)]), _: 1 }), n(a, { align: "center", key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "部件重量" }, { default: s((e) => [l("span", null, i(e.row.totalNetWeight), 1)]), _: 1 }), n(a, { align: "center", key: "nestingQuantity ", prop: "nestingQuantity ", "show-overflow-tooltip": true, label: "可套数量（件）" }, { default: s((e) => [n(M, { name: c(y).VL[e.row.nestingStatusEnum], color: c(y).V[e.row.nestingStatusEnum].COLOR, offset: 15 }, null, 8, ["name", "color"]), l("span", null, i(e.row.nestingQuantity), 1)]), _: 1 }), c(P)(c(Q).detail) ? (b(), L(a, { key: 0, align: "center", "show-overflow-tooltip": true, label: "操作" }, { default: s((e) => [n(r, { type: "primary", size: "default", onClick: (_) => D(e.row) }, { default: s(() => t[2] || (t[2] = [V("查看")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 1 })) : E("", true)]), _: 1 }, 8, ["data", "max-height"]), n(T, { visible: u.value, "onUpdate:visible": t[0] || (t[0] = (e) => u.value = e), "assemble-list": w.value }, null, 8, ["visible", "assemble-list"])], 512), [[h, p.projectData.id]])]);
  };
} }, U = q(H, [["__scopeId", "data-v-2054dba1"]]);
export {
  U as default
};
