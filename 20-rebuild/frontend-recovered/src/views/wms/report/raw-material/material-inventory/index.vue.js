import { ref as N } from "vue";
import { computed as r } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as v } from "vue";
import { unref as e } from "vue";
import { createBlock as A } from "vue";
import { withCtx as y } from "vue";
import { vLoading as E } from "element-plus";
import { g as T, _ as P } from "./module/header.vue.js";
import { t as C, jX as U, bD as S, D as s, x as V, B$ as F, o as B, cO as D, jl as R, jG as Y, jH as j, zE as k, k6 as q, P as I, cV as L, jN as M, ba as $ } from "../../../../../shared/runtime.js";
const H = { class: "app-container" }, X = { __name: "index", setup(O) {
  const { decimalPrecision: n } = C(), d = { add: false, edit: false, del: false, download: false }, u = N(), h = r(() => [...U, ["invoiceType", ["parse-enum", S, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", n.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", n.value.wms]], ["unitPriceNoFreight", ["to-thousand", n.value.wms]], ["amount", ["to-thousand", s.YUAN]], ["amountExcludingVAT", ["to-thousand", s.YUAN]], ["amountNoFreight", ["to-thousand", s.YUAN]], ["inputVAT", ["to-thousand", s.YUAN]]]), { CRUD: f, crud: o, columns: i } = V({ title: "库存报表", sort: ["id.desc"], invisibleColumns: ["createTime"], permission: { ...F }, optShow: { ...d }, crudApi: { get: T } }, u), { maxHeight: p } = B({ paginate: true }), l = r(() => o.query ? o.query.basicClass : void 0);
  function _(c) {
    const a = o.query.basicClass & L ? ["mete", M.weight.precision] : "mete";
    return $(c, { props: ["quantity", a, ["amount", s.YUAN], ["amountExcludingVAT", s.YUAN], ["amountNoFreight", s.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return f.HOOK.handleRefresh = async (c, { data: a }) => {
    a.content = await D(a.content), a.content = await R(a.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, (c, a) => {
    const g = x("common-table"), w = E;
    return m(), b("div", H, [t(P), v((m(), A(g, { ref_key: "tableRef", ref: u, data: e(o).data, "data-format": h.value, "max-height": e(p), "summary-method": _, "highlight-current-row": "", "row-key": "id", "show-summary": "" }, { default: y(() => [t(Y, { "basic-class": l.value, columns: e(i), "classify-name-alias": "名称" }, null, 8, ["basic-class", "columns"]), t(j), t(k, { "basic-class": l.value, columns: e(i), "showInput-v-a-t": false, "show-unit-price-e": "" }, null, 8, ["basic-class", "columns"]), t(q, { columns: e(i), "show-area": false, "show-monomer": false, "show-project": "" }, null, 8, ["columns"])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[w, e(o).loading]]), t(e(I))]);
  };
} };
export {
  X as default
};
