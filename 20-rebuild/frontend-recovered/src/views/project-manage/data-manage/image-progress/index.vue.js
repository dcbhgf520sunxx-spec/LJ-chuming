import { ref as p } from "vue";
import { watch as N } from "vue";
import g from "moment";
import { openBlock as t } from "vue";
import { createElementBlock as o } from "vue";
import { unref as a } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as f } from "vue";
import { Fragment as h } from "vue";
import { renderList as w } from "vue";
import { createBlock as b } from "vue";
import { toDisplayString as H } from "vue";
import { createCommentVNode as I } from "vue";
import { withCtx as O } from "vue";
import { createTextVNode as U } from "vue";
import { ElImage as V } from "element-plus";
import { ElTag as R } from "element-plus";
import { _ as B, m as E, x as q, o as z, bN as T, p as G, G as K, P as Q, Y as $, Z as F, a as Z } from "../../../../shared/runtime.js";
import { c as J } from "../../../../modules/image-progress-49ea43fe.js";
import { i as k } from "../../../../modules/project-19a12d6b.js";
import W from "./module/header.vue.js";
const X = { class: "app-container" }, ee = { key: 0 }, te = { class: "head-container" }, ae = ["max-height"], oe = { key: 1, style: { color: "red", "margin-top": "20px" } }, se = { key: 1 }, ne = { __name: "index", setup(re) {
  const { globalProjectId: m, globalProject: y } = E(["globalProjectId", "globalProject"]), Y = { add: false, edit: false, del: false, download: false }, D = p(), j = p({}), C = p({}), L = p(false), x = p(false), { crud: c, CRUD: v } = q({ title: "形象进度", sort: [], permission: { ...k }, optShow: { ...Y }, requiredQuery: ["projectId"], crudApi: { ...J }, hasPagination: true }, D), { maxHeight: P } = z({ wrapperBox: ".image-progress", paginate: true, extraHeight: 40 });
  N(() => m.value, (r) => {
    r && (c.query.projectId = m.value, c.toQuery());
  }, { immediate: true, deep: true });
  function S(r) {
    C.value = r;
  }
  function A() {
    j.value = {}, L.value = true;
  }
  async function M(r) {
    try {
      x.value = true, await $(F, r);
    } catch (i) {
      console.log("通用导出", i);
    } finally {
      x.value = false;
    }
  }
  return v.HOOK.beforeRefresh = () => (c.query.projectId = y.value.businessType === T.INSTALLATION.V ? m.value : void 0, !!c.query.projectId), v.HOOK.handleRefresh = (r, i) => {
    const s = [], d = [], u = i.data.content;
    if (u.map((e) => {
      s.indexOf(g(e.createTime).format("YYYY-MM-DD")) < 0 && s.push(g(e.createTime).format("YYYY-MM-DD"));
    }), s.length) {
      for (let e = 0; e < s.length; e++) d.push({ createTime: s[e], imageList: u.filter((n) => g(n.createTime).format("YYYY-MM-DD") === s[e]) });
      d.map((e) => {
        e.imgSrc = [], e.imageList.length && e.imageList.map((n) => {
          e.imgSrc.push(n.imageUrl), n.imgSrc = [n.imageUrl];
        });
      });
    }
    i.data.content = d;
  }, (r, i) => {
    var e;
    const s = V, d = Z, u = R;
    return t(), o("div", X, [((e = a(y)) == null ? void 0 : e.businessType) === a(T).INSTALLATION.V ? (t(), o("div", ee, [_("div", te, [f(a(W), { "project-id": a(m), onCurrentChange: S, onHandleUpload: A }, null, 8, ["project-id"])]), a(c).data.length ? (t(), o(h, { key: 0 }, [_("div", { "max-height": a(P) }, [(t(true), o(h, null, w(a(c).data, (n) => (t(), o("div", { key: n.createTime }, [(t(true), o(h, null, w(n.imageList, (l) => (t(), o("span", { key: l.id, style: { "margin-right": "20px", "text-align": "center", width: "377px", display: "inline-block", "margin-bottom": "10px" } }, [(t(), b(s, { style: { width: "100%", height: "251px" }, "preview-src-list": l.imgSrc, "initial-index": 1, key: l.id, src: l.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])), _("span", null, H(l.createTime ? a(G)(l.createTime, "{y}-{m}-{d}") : "-"), 1), a(K)(a(k).download) ? (t(), b(d, { key: 0, "icon-class": "download", style: { "font-size": "16px", "margin-left": "3px" }, onClick: (ie) => M({ id: l.id }) }, null, 8, ["onClick"])) : I("", true)]))), 128))]))), 128))], 8, ae), f(a(Q))], 64)) : (t(), o("div", oe, "*暂无数据"))])) : (t(), o("div", se, [f(u, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: O(() => i[0] || (i[0] = [U(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} }, ue = B(ne, [["__scopeId", "data-v-894f41ba"]]);
export {
  ue as default
};
