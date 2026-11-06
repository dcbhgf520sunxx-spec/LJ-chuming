import { inject as x } from "vue";
import { ref as b } from "vue";
import { computed as y } from "vue";
import { watch as A } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as C } from "vue";
import { unref as a } from "vue";
import { createBlock as r } from "vue";
import { withCtx as S } from "vue";
import { createVNode as o } from "vue";
import { Fragment as k } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as D } from "element-plus";
import { a as v } from "../../../../../../modules/psi-b34aaded.js";
import { D as g, x as B, vY as N, o as U, cO as j, cV as L, jl as O, bV as q, v3 as F, jG as H, jH as M, k6 as I, P as Y, ba as $, jN as K } from "../../../../../../shared/runtime.js";
const Q = { __name: "detail", props: { detailRow: { type: Object, define: () => {
} } }, setup(c) {
  const l = c, h = { add: false, edit: false, del: false, download: false }, u = x("orderDetailEnum"), m = b(), f = y(() => [["amountExcludingVAT", ["to-thousand", g.YUAN]], ["createTime", "parse-time"]]), { CRUD: p, crud: n } = B({ title: "订单详情", sort: [], permission: { get: N.detail }, crudApi: { get: v }, invisibleColumns: [], queryOnPresenterCreated: false, optShow: { ...h } }, m), { maxHeight: w } = U({ paginate: true });
  A(() => l.detailRow, (i) => {
    n.query = { ...l.detailRow }, n.refresh();
  }, { immediate: true }), p.HOOK.handleRefresh = async (i, { data: t }) => {
    t.content = await j(t.content), t.content.forEach((e) => {
      e.basicClass & L && (e.accountingUnit = "千克", e.accountingPrecision = 3);
    }), t.content = await O(t.content, { toNum: true }), t.content.forEach((e) => {
      e.unitPriceExcludingVAT = q(e.unitPriceExcludingVAT, F(e.unitPriceExcludingVAT));
    });
  };
  function E(i) {
    return $(i, { props: ["quantity", ["mete", K.weight.precision], ["amountExcludingVAT", g.YUAN]], toThousandFields: ["amountExcludingVAT"] });
  }
  return (i, t) => {
    const e = R, T = V("common-table"), _ = D;
    return s(), P(k, null, [C((s(), r(T, { ref_key: "tableRef", ref: m, data: a(n).data, "data-format": f.value, "max-height": a(w), "highlight-current-row": "", "row-key": "id", "show-summary": "", "summary-method": E }, { default: S(() => {
      var d;
      return [o(H), o(M), o(e, { "show-overflow-tooltip": "", key: "unitPriceExcludingVAT", prop: "unitPriceExcludingVAT", label: "单价（不含税）", "min-width": "130", align: "right" }), o(e, { "show-overflow-tooltip": "", key: "amountExcludingVAT", prop: "amountExcludingVAT", label: "金额（不含税）", "min-width": "130", align: "right" }), c.detailRow.type === a(u).STOCK.V ? (s(), r(I, { key: 0 })) : (s(), r(e, { "show-overflow-tooltip": "", key: "createTime", prop: "createTime", label: `${(d = a(u).V) == null ? void 0 : d[c.detailRow.type].SL}日期`, width: "150", align: "center" }, null, 8, ["label"]))];
    }), _: 1 }, 8, ["data", "data-format", "max-height"])), [[_, a(n).loading]]), o(a(Y))], 64);
  };
} };
export {
  Q as default
};
