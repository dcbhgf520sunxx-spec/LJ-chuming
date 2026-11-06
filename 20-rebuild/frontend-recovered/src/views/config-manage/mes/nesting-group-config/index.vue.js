import { ref as d } from "vue";
import { watch as V } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as D } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as u } from "vue";
import { ElMessageBox as P } from "element-plus";
import { ElNotification as H } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElSwitch as T } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as f, o as $ } from "../../../../modules/nesting-group-config-c479d3e5.js";
import { x as A, fC as F, o as M, aS as l, an as O, P as I } from "../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import q from "./module/form.vue.js";
import "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
const G = { class: "app-container" }, K = { class: "head-container" }, ee = { __name: "index", props: { isRefresh: { type: Boolean, default: false } }, setup(g) {
  const w = g, _ = [], y = { add: true, edit: false, del: false, download: false }, p = d(), x = d([]), { crud: r, CRUD: C } = A({ title: "套料团队", sort: [], optShow: { ...y }, permission: { ...F }, crudApi: { ...f } }, p), { maxHeight: b } = M({ wrapperBox: [".app-container"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  V(() => w.isRefresh, () => {
    r.toQuery();
  });
  async function k(o, s) {
    try {
      await P.confirm(`此操作将 ${o.nestingChargePersonName} 的状态改为 ${l.VL[s]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await f.edit({ id: o.id, boolDrillHole: s ? 1 : 0, company: o.company, nestingChargePerson: o.nestingChargePerson, teamCode: o.teamCode, workshopId: o.workshopId }), s && $({ teamCode: o.teamCode }), r.toQuery(), H({ title: `${o.nestingChargePersonName}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (e) {
      console.log("变更失败", e), o.state = o.state === l.TRUE.V ? l.FALSE.V : l.TRUE.V;
    }
  }
  return C.HOOK.handleRefresh = (o, s) => {
    s.data.content = s.data.content.map((e) => (e.state = !!e.boolDrillHole, e.company = Number(e.company), e));
  }, (o, s) => {
    const e = L, v = T, N = E("common-table"), B = U;
    return h(), S("div", G, [c("div", K, [t(n(Q), { workShopList: x.value }, null, 8, ["workShopList"])]), R((h(), D(N, { ref_key: "tableRef", ref: p, data: n(r).data, "data-format": _, "empty-text": n(r).emptyText, "max-height": n(b), style: { width: "100%" }, "row-key": "id" }, { default: i(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": true, label: "单位", "min-width": "100px", align: "center" }, { default: i(({ row: a }) => [c("span", null, u(a.companyName), 1)]), _: 1 }), t(e, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": true, label: "车间", "min-width": "100px", align: "center" }, { default: i(({ row: a }) => [c("span", null, u(a.workshopName), 1)]), _: 1 }), t(e, { key: "nestingChargePersonName", prop: "nestingChargePersonName", label: "套料负责人", align: "center" }), t(e, { key: "teamCode", prop: "teamCode", label: "团队编码", align: "center" }), t(e, { align: "center", key: "boolDrillHole", prop: "boolDrillHole", "show-overflow-tooltip": true, label: "状态" }, { default: i(({ row: a }) => [t(v, { modelValue: a.state, "onUpdate:modelValue": (m) => a.state = m, "active-value": n(l).TRUE.V, "inactive-value": n(l).FALSE.V, class: "drawer-switch", onChange: (m) => k(a, a.state) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])]), _: 1 }), t(e, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: i((a) => [t(n(O), { data: a.row, showDel: false }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, n(r).loading]]), t(n(I)), t(n(q))]);
  };
} };
export {
  ee as default
};
