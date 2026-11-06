import { ref as p } from "vue";
import { provide as D } from "vue";
import { computed as N } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as A } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as u } from "vue";
import { withCtx as f } from "vue";
import { resolveDynamicComponent as F } from "vue";
import { Fragment as $ } from "vue";
import { createTextVNode as O } from "vue";
import { toDisplayString as Y } from "vue";
import { createCommentVNode as I } from "vue";
import { ElMessageBox as M } from "element-plus";
import { ElNotification as j } from "element-plus";
import { ElTag as q } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { vLoading as G } from "element-plus";
import { l as s, x as Q, o as W, D as y, jf as _, c3 as h, an as z, P as J, aS as l, ba as K } from "../../../../shared/runtime.js";
import { a as X } from "../../../../modules/common-f216149e.js";
import { y as E } from "../../../../modules/contract-9b18cc88.js";
import Z from "./module/header.vue.js";
import tt from "./module/form.vue.js";
import et from "./module/electric-cost-table.vue.js";
import at from "./module/property-cost-table.vue.js";
import ot from "./module/water-cost-table.vue.js";
function rt(a) {
  return s({ module: "contract", url: "contract/water-electricity-property-fee/page", method: "get", params: a });
}
function nt(a) {
  return s({ module: "contract", url: "contract/water-electricity-property-fee", method: "post", data: a });
}
function st(a) {
  return s({ module: "contract", url: "contract/water-electricity-property-fee", method: "put", data: a });
}
function ct(a) {
  return s({ module: "contract", url: `contract/water-electricity-property-fee/${a}`, method: "delete" });
}
function it(a) {
  return s({ module: "contract", url: "contract/water-electricity-property-fee/update-status", method: "put", params: a });
}
const ut = { get: rt, add: nt, edit: st, del: ct }, lt = { class: "app-container" }, mt = { class: "head-container" }, St = { __name: "index", setup(a) {
  const g = p(), m = p(), S = { add: true, edit: false, del: false, download: false }, { crud: r, columns: b } = Q({ title: "水电物业费", sort: [], optShow: { ...S }, permission: { ...E }, crudApi: { ...ut }, invisibleColumns: [], hasPagination: true }, g);
  D("columns", b);
  const { maxHeight: T } = W({ paginate: true });
  async function x(t, c) {
    console.log(t, c);
    try {
      await M.confirm(`此操作将 物业费的状态改为 ${l.VL[c]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await it({ id: t.id, boolStatus: c }), r.toQuery(), j({ title: "物业费状态修改成功", type: "success", duration: 3e3 });
    } catch (d) {
      console.log("物业费状态修改失败", d), t.boolStatus = t.boolStatus === l.TRUE.V ? l.FALSE.V : l.TRUE.V;
    }
  }
  const C = p([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["totalFee", ["to-thousand", y.YUAN]], ["averageUnitPrice", ["to-thousand", y.YUAN]]]);
  async function V() {
    try {
      const { content: t } = await X();
      m.value = t;
    } catch (t) {
      console.log(t);
    }
  }
  const v = N(() => {
    switch (r.query.type) {
      case _.ELECTRIC_COST.V:
        return et;
      case _.PROPERTY_COST.V:
        return at;
      case _.WATER_COST.V:
        return ot;
      default:
        return null;
    }
  });
  V();
  function L(t) {
    return K(t, { props: ["consumption", ["totalFee", y.YUAN]], toThousandFields: ["totalFee"] });
  }
  return (t, c) => {
    const d = q, P = H, k = R("common-table"), B = G;
    return o(), w("div", lt, [A("div", mt, [i(e(Z), { branchList: m.value }, null, 8, ["branchList"])]), U((o(), u(k, { ref_key: "tableRef", ref: g, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(T), "row-key": "id", style: { width: "100%" }, "show-summary": "", "data-format": C.value, "summary-method": L }, { default: f(() => [(o(), u(F(v.value), { onChangeStatus: x }, null, 32)), i(P, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: f((n) => [n.row.auditStatusEnum === e(h).AUDITING.V ? (o(), u(e(z), { key: 0, data: n.row, permission: e(E) }, null, 8, ["data", "permission"])) : (o(), w($, { key: 1 }, [n.row.auditStatusEnum ? (o(), u(d, { key: 0, type: e(h).V[n.row.auditStatusEnum].TYPE }, { default: f(() => [O(Y(e(h).VL[n.row.auditStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : I("", true)], 64))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[B, e(r).loading]]), i(e(J)), i(tt, { branchList: m.value }, null, 8, ["branchList"])]);
  };
} };
export {
  St as default
};
