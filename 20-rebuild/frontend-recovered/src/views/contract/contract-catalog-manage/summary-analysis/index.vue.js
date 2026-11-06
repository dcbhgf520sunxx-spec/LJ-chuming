import { ref as f } from "vue";
import { computed as S } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as g } from "vue";
import { unref as t } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as n } from "vue";
import { withCtx as D } from "vue";
import { Fragment as d } from "vue";
import { createCommentVNode as r } from "vue";
import { renderList as L } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as R, m as q } from "./module/header.vue.js";
import { i as E } from "../../../../modules/contract-9b18cc88.js";
import { _ as H, x as O, o as Y, iq as A, ba as M } from "../../../../shared/runtime.js";
const B = { class: "app-container" }, F = { __name: "index", setup(I) {
  const _ = { add: false, edit: false, del: false, download: false }, y = f(), b = f(), c = f([]), k = S(() => {
    var u;
    const h = [["totalAmount", ["to-thousand-text"]], ["unSignAmount", ["to-thousand-text"]], ["lastYearAmount", ["to-thousand-text"]], ["coordinateAmount", ["to-thousand-text"]], ["unCoordinateAmount", ["to-thousand-text"]], ["signAmount", ["to-thousand-text"]], ["monthTotalAmount", ["to-thousand-text"]]];
    return (u = c.value) == null || u.forEach((o) => {
      h.push([o.key, ["to-thousand-text"]]);
    }), h;
  }), { crud: p, columns: l, CRUD: w } = O({ title: "汇总分析", sort: [], permission: { ...E }, crudApi: R, dataPath: "", invisibleColumns: [], optShow: { ..._ }, hasPagination: false, queryOnPresenterCreated: false }, y), { maxHeight: v } = Y({});
  w.HOOK.handleRefresh = (h, { data: u }) => {
    var o;
    c.value = [], u.forEach((a) => {
      a.amountList = [], a.monthTotalAmount = 0;
      for (const s in a.mapAmount) {
        const i = s + "_" + (a.amountList.length + 1);
        a.amountList.push({ key: i, dataName: s }), a[i] = a.mapAmount[s], a.monthTotalAmount += a.mapAmount[s] || 0;
      }
      return a;
    }), c.value = (o = u[0]) == null ? void 0 : o.amountList;
  };
  function x(h) {
    var a;
    const u = [], o = ["totalAmount", "signAmount", "unSignAmount", "lastYearAmount", "coordinateAmount", "unCoordinateAmount", "monthTotalAmount"];
    return (a = c.value) == null || a.forEach((s) => {
      u.push([s.key, 4]), o.push(s.key);
    }), M(h, { props: [["totalAmount", 4], ["signAmount", 4], ["unSignAmount", 4], ["lastYearAmount", 4], ["coordinateAmount", 4], ["unCoordinateAmount", 4], ["monthTotalAmount", 4], ...u], toThousandFields: o });
  }
  return (h, u) => {
    const o = N, a = C("common-table"), s = V;
    return e(), m("div", B, [g(t(q), { ref_key: "headerRef", ref: b }, null, 512), T((e(), n(a, { ref_key: "tableRef", ref: y, "data-format": k.value, data: t(p).data, "show-summary": "", "summary-method": x, style: { width: "100%" }, "max-height": t(v) }, { default: D(() => [t(p).query.type === t(A).MONTH.V ? (e(), m(d, { key: 0 }, [t(l).visible("monthStr") ? (e(), n(o, { key: "monthStr", prop: "monthStr", "show-overflow-tooltip": true, label: "月份", width: "80", align: "center", fixed: "left" })) : r("", true)], 64)) : (e(), m(d, { key: 1 }, [g(o, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(l).visible("firstLevelDeptValue") ? (e(), n(o, { key: "firstLevelDeptValue", prop: "firstLevelDeptValue", "show-overflow-tooltip": true, label: "所属一级部门名称", align: "center" })) : r("", true), t(l).visible("totalAmount") ? (e(), n(o, { key: "totalAmount", prop: "totalAmount", "show-overflow-tooltip": true, label: "总合同额", align: "right" })) : r("", true)], 64)), t(p).query.type === t(A).SIGN.V ? (e(), m(d, { key: 2 }, [t(l).visible("signAmount") ? (e(), n(o, { key: "signAmount", prop: "signAmount", "show-overflow-tooltip": true, label: "其中：已签订", align: "right" })) : r("", true), t(l).visible("unSignAmount") ? (e(), n(o, { key: "unSignAmount", prop: "unSignAmount", "show-overflow-tooltip": true, label: "其中：中标未签", align: "right" })) : r("", true), t(l).visible("lastYearAmount") ? (e(), n(o, { key: "lastYearAmount", prop: "lastYearAmount", "show-overflow-tooltip": true, label: "上年度遗留（独立数据）", align: "right" })) : r("", true)], 64)) : t(p).query.type === t(A).COORDINATE.V ? (e(), m(d, { key: 3 }, [t(l).visible("coordinateAmount") ? (e(), n(o, { key: "coordinateAmount", prop: "coordinateAmount", "show-overflow-tooltip": true, label: "其中：配合项目部的合同额", align: "right" })) : r("", true), t(l).visible("unCoordinateAmount") ? (e(), n(o, { key: "unCoordinateAmount", prop: "unCoordinateAmount", "show-overflow-tooltip": true, label: "其中：自主承接的合同额", align: "right" })) : r("", true)], 64)) : (e(true), m(d, { key: 4 }, L(c.value, (i) => (e(), m(d, { key: i.key }, [t(l).visible(i.key) ? (e(), n(o, { key: i.key, prop: i.key, "show-overflow-tooltip": true, label: i.dataName, align: "right" }, null, 8, ["prop", "label"])) : r("", true)], 64))), 128)), t(p).query.type === t(A).MONTH.V ? (e(), m(d, { key: 5 }, [t(l).visible("monthTotalAmount") ? (e(), n(o, { key: "monthTotalAmount", prop: "monthTotalAmount", "show-overflow-tooltip": true, label: "总计", align: "right", fixed: "right" })) : r("", true)], 64)) : r("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[s, t(p).loading]])]);
  };
} }, j = H(F, [["__scopeId", "data-v-b504e87e"]]);
export {
  j as default
};
