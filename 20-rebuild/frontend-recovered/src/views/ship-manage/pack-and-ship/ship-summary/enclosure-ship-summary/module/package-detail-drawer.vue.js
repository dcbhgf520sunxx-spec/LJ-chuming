import { ref as k } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as w } from "vue";
import { createBlock as y } from "vue";
import { withCtx as g } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as S } from "vue";
import { withDirectives as P } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as x } from "vue";
import { createElementVNode as U } from "vue";
import { isRef as q } from "vue";
import { ElTag as M } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as A } from "element-plus";
import { p as J } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { uo as Y, u as F, J as G, o as K, c as E, D as W } from "../../../../../../shared/runtime.js";
const ee = { __name: "package-detail-drawer", props: { visible: { type: Boolean, default: false }, packageInfo: { type: Object, default: () => {
} }, query: { type: Object }, workshopId: { type: Number }, projectId: { type: Number }, category: { type: [Number, String], default: Y.STRUCTURE.V }, weightStatus: { type: Number } }, emits: ["update:visible", "changeDate"], setup(_, { emit: I }) {
  const V = I, d = k([]), h = k(false), s = _, { visible: f, handleClose: T } = F({ emit: V, props: s, field: "visible", showHook: N }), { handleSizeChange: z, handleCurrentChange: D, total: L, setTotalPage: B, queryPage: b } = G({ fetchHook: N }), { maxHeight: R } = K({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, f);
  async function N() {
    d.value = [], h.value = true;
    try {
      const r = { projectId: s.projectId, ...s.query, workshopId: s.workshopId, packageId: s.packageInfo.id, ...b }, { content: i = [], totalElements: p } = await J(r);
      d.value = i, B(p), h.value = false, console.log(d.value);
    } catch (r) {
      console.log("获取详情失败", r), h.value = false;
    }
  }
  function j(r) {
    const { columns: i, data: p } = r, t = [];
    return i.forEach((u, c) => {
      if (c === 0) {
        t[c] = "合计";
        return;
      }
      if (u.property === "packageQuantity") {
        const l = p.map((e) => Number(e[u.property]));
        let n = 0;
        l.every((e) => isNaN(e)) || (n = l.reduce((e, m) => {
          const v = Number(m);
          return isNaN(v) ? e : e + m;
        }, 0)), t[c] = n;
      }
      if (u.property === "totalLength") {
        const l = p.map((e) => Number(e[u.property]));
        let n = 0;
        l.every((e) => isNaN(e)) || (n = l.reduce((e, m) => {
          const v = Number(m);
          return isNaN(v) ? e : e + m;
        }, 0)), t[c] = E(n, "mm", "m", 2);
      }
    }), t;
  }
  return (r, i) => {
    const p = M, t = O, u = C("common-table"), c = Q, l = C("common-drawer"), n = A;
    return w(), y(l, { ref: "drawerRef", "custom-class": "detail-drawer", title: "打包明细", modelValue: a(f), "onUpdate:modelValue": i[0] || (i[0] = (e) => q(f) ? f.value = e : null), direction: "rtl", "before-close": a(T), size: "70%" }, { titleAfter: g(() => [o(p, { effect: "plain" }, { default: g(() => [H("包单号：" + S(_.packageInfo.serialNumber), 1)]), _: 1 })]), content: g(() => [P((w(), y(u, { data: d.value, "show-summary": "", "summary-method": j, style: { width: "100%" }, "max-height": a(R) - 70 }, { default: g(() => [o(t, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), r.showType !== "INVENTORY" ? (w(), y(t, { key: "workshopName", prop: "workshopName", label: "车间", align: "center", "show-overflow-tooltip": true })) : x("", true), o(t, { key: "area.name", prop: "area.name", label: "批次", align: "center", "show-overflow-tooltip": true }), o(t, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), o(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), s.category !== 32 ? (w(), y(t, { key: "plate", prop: "plate", label: "板型", align: "center", "show-overflow-tooltip": true, "min-width": "120px" })) : x("", true), o(t, { key: "length", prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": true }), o(t, { key: "packageQuantity", prop: "packageQuantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "80px" }), o(t, { key: "totalLength", prop: "totalLength", label: "总长（m）", align: "center", "show-overflow-tooltip": true }, { default: g(({ row: e }) => [U("span", null, S(a(E)(e.totalLength, "mm", "m", a(W).MES_ENCLOSURE_L__M) || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[n, h.value]]), o(c, { total: a(L), "current-page": a(b).pageNumber, "page-size": a(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(z), onCurrentChange: a(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ee as default
};
